package com.medianet.fishingCompetiton.controllers;

import com.medianet.fishingCompetiton.jwt.JwtUtils;
import com.medianet.fishingCompetiton.jwt.LoginRequest;
import com.medianet.fishingCompetiton.jwt.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Authentication", description = "Endpoints for user login and secured role-based testing")
public class SignInController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    @Operation(summary = "Say hello", description = "Basic test endpoint, publicly accessible")
    public String sayHello() {
        return "Hello";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    @Operation(summary = "User access", description = "Accessible only to users with ROLE_USER")
    public String userEndpoint() {
        return "Hello, User!";
    }

    @GetMapping("/admin")
    @Operation(summary = "Admin access", description = "Accessible only to users with ROLE_ADMIN")
    public String adminEndpoint() {
        return "Hello, Admin!";
    }

    @PostMapping("/api/public/signin")
    @Operation(
            summary = "User login",
            description = "Authenticates a user with username and password and returns a JWT token upon success",
            requestBody = @RequestBody(
                    required = true,
                    description = "Login credentials",
                    content = @Content(schema = @Schema(implementation = LoginRequest.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful. Returns username, roles, and JWT token"),
                    @ApiResponse(responseCode = "404", description = "Invalid credentials", content = @Content)
            }
    )
    public ResponseEntity<?> authenticateUser(@org.springframework.web.bind.annotation.RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (AuthenticationException exception) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        LoginResponse response = new LoginResponse(userDetails.getUsername(), roles, jwtToken);

        return ResponseEntity.ok(response);
    }
}
