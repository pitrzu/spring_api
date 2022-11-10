package com.pitrzuu.api.order;

import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.status.EOrderStatus;
import com.pitrzuu.api.status.IOrderStatusRepository;
import com.pitrzuu.api.status.OrderStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("/api/v1")
@RestController
public class OrderController{
    public OrderController( IOrderStatusRepository orderStatusesRepository,
                            OrderService ordersService,
                            OrderMapper orderMapper ){
        this.orderStatusesRepository = orderStatusesRepository;
        this.ordersService = ordersService;
        this.orderMapper = orderMapper;
    }

    private final IOrderStatusRepository orderStatusesRepository;
    private final OrderService ordersService;
    private final OrderMapper orderMapper;

    @GetMapping("/order/{id}")
    public ResponseEntity<?> oneById( @PathVariable Long id ){
        Order order = ordersService.findOrderById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity
                .ok()
                .body(EntityModel.of(orderMapper.createDto(order),
                        linkTo(methodOn(OrderController.class).oneById(id)).withSelfRel(),
                        linkTo(methodOn(OrderController.class).all()).withRel("orders")
                ));
    }

    @GetMapping("admin/orders")
    public ResponseEntity<?> all(){
        Collection<Order> orders = ordersService.findAll();
        return ResponseEntity.ok().body(
                CollectionModel.of(orders.stream().map(order ->
                        EntityModel.of(orderMapper.createDto(order),
                                linkTo(methodOn(OrderController.class).oneById(order.getId())).withSelfRel(),
                                linkTo(methodOn(OrderController.class).all()).withRel("orders")
                        )).collect(Collectors.toList()),
                linkTo(methodOn(OrderController.class).all()).withSelfRel()
        ));
    }

    @PostMapping("/order")
    public ResponseEntity<?> create(@RequestBody CreateOrderDto dto){
        Order order = ordersService.create(orderMapper.createEntity(dto));
        EntityModel<GetOrderDto> model = EntityModel.of(orderMapper.createDto(order),
                linkTo(methodOn(OrderController.class).oneById(order.getId())).withSelfRel()
        );
        return ResponseEntity
                .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(model);
    }

    @PutMapping("/order/{id}/completed")
    public ResponseEntity<?> complete(@PathVariable Long id){
        Order order = ordersService.findOrderById(id).orElseThrow(EntityNotFoundException::new);
        if(order.getLatestStatus().getOrderStatus() != EOrderStatus.IN_DELIVERY)
            return ResponseEntity.badRequest().body(order);
        orderStatusesRepository.save(new OrderStatus(order, EOrderStatus.COMPLETED));
        return ResponseEntity.ok().body(order);
    }
}
