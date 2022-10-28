package com.pitrzuu.api.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserById(Integer id){
        return repository.findById(id).get();
    }

    public List<User> listAllUsers(){
        return repository.findAll();
    }

    public void deleteUserById(Integer id){
        repository.deleteById(id);
    }

    public void saveUser(User user){
        repository.save(user);
    }

}
