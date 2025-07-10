package com.medianet.fishingCompetiton.controllers;

import com.medianet.fishingCompetiton.DAOs.UserDao;
import com.medianet.fishingCompetiton.DTOs.SignUpDTO;
import com.medianet.fishingCompetiton.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.medianet.fishingCompetiton.models.Role.PLAYER;

@RestController

public class SignUpController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/api/public/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDTO signUpDTO){
        if(userDao.findByPhoneNumber(signUpDTO.getPhoneNumber()).isPresent()){
            return  ResponseEntity.badRequest().body("ERROR: Phone number already taken");
        }
        User user = new User(
                signUpDTO.getFirstName(),
                signUpDTO.getLastName(),
                signUpDTO.getPhoneNumber(),
                null,
                passwordEncoder.encode(signUpDTO.getPassword()),
                PLAYER);
        userDao.save(user);
        return ResponseEntity.ok("Player registered successfully");

    }


}
