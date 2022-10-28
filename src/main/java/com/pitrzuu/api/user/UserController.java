package com.pitrzuu.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("")
    @ResponseBody
    public List<User> getAllUsers(){
        return service.listAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        service.saveUser(user);
    }

    @DeleteMapping("/remove/{id}")
    public void removeUser(@PathVariable Integer id){
        service.deleteUserById(id);
    }
}
