package com.pitrzuu.api.order;

import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.order.status.OrderStatusDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/order")
public class OrderController{
    public OrderController( OrderService ordersService){
        this.ordersService = ordersService;
    }

    private final OrderService ordersService;

    @GetMapping("/{id}")
    ResponseEntity<GetOrderDto> findOrderById( @PathVariable Long id ){
        return new ResponseEntity<>(
                ordersService.findOrderById(id),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    ResponseEntity<GetOrderDto> placeOrder( @Valid @RequestBody CreateOrderDto orderDto ){
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleItemNotFoundException(
            NoSuchElementException exception,
            WebRequest request
    ){
        return new ResponseEntity<>(
                exception.toString(),
                HttpStatus.NOT_FOUND
        );
    }
}
