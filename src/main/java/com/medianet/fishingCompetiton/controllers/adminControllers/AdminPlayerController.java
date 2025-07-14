package com.medianet.fishingCompetiton.controllers.adminControllers;


import com.medianet.fishingCompetiton.DTOs.user.UpdateUserDTO;
import com.medianet.fishingCompetiton.DTOs.user.UserResponseDTO;
import com.medianet.fishingCompetiton.mappers.UserMapper;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.services.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/api/admin/user")
public class AdminPlayerController {
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    UserMapper userMapper;

    @GetMapping()
    public List<UserResponseDTO> getUsers() {
        return adminUserService.getAllUsers()
                .stream()
                .map(userMapper::apply) // ✅ or .map(this::convertToDto) if inside service
                .toList(); // or .collect(Collectors.toList()) for Java 8
    }

    @GetMapping("{id}")
    UserResponseDTO getUserById(@PathVariable int id) {
        return userMapper.apply(adminUserService.getUserById(id));
    }

    @PostMapping
    void createUser(@RequestBody User user) {
        adminUserService.createUser(user);
    }

    @PutMapping("{id}")
    void updateUser(@PathVariable int id, @RequestBody UpdateUserDTO dto) {
        adminUserService.updateUser(id, dto);
    }
    @DeleteMapping("{id}")
    void deleteUser(@PathVariable int id){
        adminUserService.deleteUser(id);
    }

}
