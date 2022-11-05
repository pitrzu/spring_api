package com.pitrzuu.api.order.business;

import com.pitrzuu.api.location.Location;
import com.pitrzuu.api.order.Order;
import com.pitrzuu.api.order.dto.CreateOrderDTO;
import com.pitrzuu.api.order.dto.GetOrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController{
    public OrderController( OrderService ordersService){
        this.ordersService = ordersService;
    }

    private final OrderService ordersService;

    @PostMapping("/")
    ResponseEntity<GetOrderDTO> placeOrder( @RequestBody CreateOrderDTO orderDTO){
        Location location = new Location()
                .setEmail(orderDTO.getLocationDTO().getEmail())
                .setPhone(orderDTO.getLocationDTO().getPhone())
                .setFirstName(orderDTO.getLocationDTO().getFirstName())
                .setLastName(orderDTO.getLocationDTO().getLastName())
                .setCity(orderDTO.getLocationDTO().getCity())
                .setPostCode(orderDTO.getLocationDTO().getPostCode())
                .setStreetNumber(orderDTO.getLocationDTO().getStreetNumber())
                .setStreet(orderDTO.getLocationDTO().getStreet());
        Order order = new Order()
                .setLocation(location)
                .setCustomerComment(orderDTO.getCustomerComment());
        ordersService.placeOrder(order);
        return new ResponseEntity<>(
                new GetOrderDTO(order), HttpStatus.OK
        );
    }
}
