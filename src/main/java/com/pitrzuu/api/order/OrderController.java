package com.pitrzuu.api.order;

import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.status.EOrderStatus;
import com.pitrzuu.api.status.IOrderStatusRepository;
import com.pitrzuu.api.status.OrderStatus;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

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
        Order order = ordersService.findOrderById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Order with id %d not found", id)));
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
    public ResponseEntity<?> create(@Valid @RequestBody CreateOrderDto dto){
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
        Order order = ordersService.findOrderById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Order with id %d not found!", id)));
        if(order.getLatestStatus().getOrderStatus() != EOrderStatus.IN_DELIVERY)
            return ResponseEntity.badRequest().body(orderMapper.createDto(order));
        orderStatusesRepository.save(new OrderStatus(order, EOrderStatus.COMPLETED));
        return ResponseEntity.ok().body(orderMapper.createDto(order));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> notFound( RuntimeException e, WebRequest request ){
        return new ResponseEntity<>(
                e.getMessage(),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND
        );
    }
}
