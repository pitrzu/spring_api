package com.pitrzuu.api.order;

import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.order.status.OrderStatusDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController{
    public OrderController( OrderService ordersService){
        this.ordersService = ordersService;
    }

    private final OrderService ordersService;

    @GetMapping("/{id}")
    ResponseEntity<GetOrderDto> findOrderById( @PathVariable Long id ){
        GetOrderDto orderDto = ordersService.findOrderById(id);
        if(orderDto.equals(new GetOrderDto())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(
          orderDto,
          new HttpHeaders(),
          HttpStatus.OK
        );
    }
    @PostMapping("/")
    ResponseEntity<GetOrderDto> placeOrder( @RequestBody CreateOrderDto orderDto){
        return new ResponseEntity<>(
                ordersService.placeOrder(orderDto),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }
    @PostMapping("/{id}/status/{status}")
    ResponseEntity<OrderStatusDto> updateStatus(@PathVariable Long id, @PathVariable String status){
        return new ResponseEntity<>(
                ordersService.updateStatus(id, status),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }
}
