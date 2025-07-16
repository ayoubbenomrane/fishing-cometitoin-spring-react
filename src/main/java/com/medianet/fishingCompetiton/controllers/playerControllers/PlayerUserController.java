package com.medianet.fishingCompetiton.controllers.playerControllers;

import com.medianet.fishingCompetiton.DTOs.user.PlayerResponseDTO;
import com.medianet.fishingCompetiton.jwt.JwtUtils;
import com.medianet.fishingCompetiton.mappers.PlayerMapper;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.services.player.PlayerUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/player")
@Tag(name = "Player - Profile and Listings", description = "Endpoints for players to view their own profile and see other participants")
public class PlayerUserController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PlayerUserService playerUserService;

    @Autowired
    PlayerMapper playerMapper;

    @GetMapping("myData")
    @Operation(
            summary = "Get current player data",
            description = "Returns the authenticated player's full profile information"
    )
    public User getMyData(HttpServletRequest request) {
        return playerUserService.getMyData(request);
    }

    @GetMapping("players")
    @Operation(
            summary = "Get list of all players",
            description = "Returns a list of all registered players in the system"
    )
    public List<PlayerResponseDTO> getPlayers() {
        return playerUserService.getAllUsers()
                .stream()
                .map(playerMapper::apply)
                .toList();
    }
}
