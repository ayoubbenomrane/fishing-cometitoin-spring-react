package com.medianet.fishingCompetiton.controllers;

import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping
    public void create(User user){
        userService.createUser(user);
    }
    public void update(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
