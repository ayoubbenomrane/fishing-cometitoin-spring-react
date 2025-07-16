package com.medianet.fishingCompetiton.controllers.adminControllers;

import com.medianet.fishingCompetiton.DTOs.user.UpdateUserDTO;
import com.medianet.fishingCompetiton.DTOs.user.UserResponseDTO;
import com.medianet.fishingCompetiton.mappers.UserMapper;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.services.admin.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
@Tag(name = "Admin - Users", description = "Admin operations for managing users (players and staff)")
public class AdminPlayerController {

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    UserMapper userMapper;

    @GetMapping
    @Operation(
            summary = "Get all users",
            description = "Returns a list of all users including players and staff"
    )
    public List<UserResponseDTO> getUsers() {
        return adminUserService.getAllUsers()
                .stream()
                .map(userMapper::apply)
                .toList();
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Get user by ID",
            description = "Returns the details of a specific user based on their ID"
    )
    public UserResponseDTO getUserById(@PathVariable int id) {
        return userMapper.apply(adminUserService.getUserById(id));
    }

    @PostMapping
    @Operation(
            summary = "Create a new user",
            description = "Creates a new user in the system (admin, player, or referee)"
    )
    public void createUser(@RequestBody User user) {
        adminUserService.createUser(user);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Update user information",
            description = "Updates the data of an existing user identified by their ID"
    )
    public void updateUser(@PathVariable int id, @RequestBody UpdateUserDTO dto) {
        adminUserService.updateUser(id, dto);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete a user",
            description = "Deletes a user from the system based on their ID"
    )
    public void deleteUser(@PathVariable int id){
        adminUserService.deleteUser(id);
    }

}
