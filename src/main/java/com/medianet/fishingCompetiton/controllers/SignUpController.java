package com.medianet.fishingCompetiton.controllers;

import com.medianet.fishingCompetiton.DAOs.UserDao;
import com.medianet.fishingCompetiton.DTOs.user.SignUpDTO;
import com.medianet.fishingCompetiton.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.medianet.fishingCompetiton.models.Role.PLAYER;

@RestController
@Tag(name = "Authentication", description = "Endpoints for user sign-up and login")
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/api/public/signup")
    @Operation(
            summary = "Register a new player",
            description = "Creates a new player account with default role PLAYER",
            requestBody = @RequestBody(
                    required = true,
                    description = "Player registration details",
                    content = @Content(schema = @Schema(implementation = SignUpDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Player registered successfully"),
                    @ApiResponse(responseCode = "400", description = "Phone number already taken")
            }
    )
    public ResponseEntity<?> registerUser(@org.springframework.web.bind.annotation.RequestBody SignUpDTO signUpDTO) {
        if (userDao.findByPhoneNumber(signUpDTO.getPhoneNumber()).isPresent()) {
            return ResponseEntity.badRequest().body("ERROR: Phone number already taken");
        }

        User user = new User(
                signUpDTO.getFirstName(),
                signUpDTO.getLastName(),
                signUpDTO.getPhoneNumber(),
                null,
                signUpDTO.getEmail(),
                passwordEncoder.encode(signUpDTO.getPassword()),
                PLAYER
        );

        userDao.save(user);
        return ResponseEntity.ok("Player registered successfully");
    }
}
