package com.medianet.fishingCompetiton.controllers.playerControllers;


import com.medianet.fishingCompetiton.DTOs.user.PlayerResponseDTO;
import com.medianet.fishingCompetiton.jwt.JwtUtils;
import com.medianet.fishingCompetiton.mappers.PlayerMapper;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.repositories.UserRepository;
import com.medianet.fishingCompetiton.services.admin.AdminUserService;
import com.medianet.fishingCompetiton.services.player.PlayerUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/player")
public class PlayerUserController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PlayerUserService playerUserService;

    @Autowired
    PlayerMapper playerMapper;


    @GetMapping("myData")
    User getMyData(HttpServletRequest request){
        return playerUserService.getMyData(request);
    }

    @GetMapping("players")
    List<PlayerResponseDTO> getPlayers(){
        return playerUserService.getAllUsers().stream().map(playerMapper::apply).toList();
    }



}
