package com.pitrzuu.api.order;

import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.OrderDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController{
    public OrderController(OrderService ordersService){
        this.ordersService = ordersService;
    }

    private final OrderService ordersService;

    @GetMapping("/{id}")
    ResponseEntity<OrderDto> findOrderById( @PathVariable Long id ){
        OrderDto orderDto = ordersService.findOrderById(id);
        if(orderDto.equals(new OrderDto())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(
          orderDto,
          new HttpHeaders(),
          HttpStatus.OK
        );
    }

    @PostMapping("/")
    ResponseEntity<OrderDto> placeOrder( @RequestBody CreateOrderDto orderDto){
        return new ResponseEntity<>(
                ordersService.placeOrder(orderDto),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }
}
