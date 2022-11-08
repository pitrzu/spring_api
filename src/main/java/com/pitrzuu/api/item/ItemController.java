package com.pitrzuu.api.item;

import com.pitrzuu.api.item.dto.CreateItemDto;
import com.pitrzuu.api.item.dto.ItemDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController{
    public ItemController( ItemService itemsService ){this.itemsService = itemsService;}

    private final ItemService itemsService;

    @GetMapping("/items")
    ResponseEntity<List<ItemDto>> getAllItems(){
        return new ResponseEntity<>(
                itemsService.getItems(),
                new HttpHeaders(),
                HttpStatus.OK
        );
    }

    @PostMapping("/item")
    ResponseEntity<ItemDto> createItem(@RequestBody CreateItemDto itemDto){
        return new ResponseEntity<ItemDto>(
                itemsService.addItem(itemDto),
                new HttpHeaders(),
                HttpStatus.OK
        );

    }

    @DeleteMapping("/item/{id}")
    ResponseEntity<String> removeItem( @NotNull @PathVariable Integer id ){
        itemsService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
