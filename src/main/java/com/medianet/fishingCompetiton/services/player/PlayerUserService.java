package com.medianet.fishingCompetiton.services.player;


import com.medianet.fishingCompetiton.jwt.JwtUtils;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtUtils jwtUtils;

    public User getMyData(HttpServletRequest request){
    String token= jwtUtils.getJwtFromHeader(request);
    String email=jwtUtils.getUserNameFromJwtToken(token);
        return  userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("ERROR"));
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
