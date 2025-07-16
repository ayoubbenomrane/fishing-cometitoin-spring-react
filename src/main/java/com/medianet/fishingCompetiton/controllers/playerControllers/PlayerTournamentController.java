package com.medianet.fishingCompetiton.controllers.playerControllers;

import com.medianet.fishingCompetiton.models.Round;
import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.repositories.UserRepository;
import com.medianet.fishingCompetiton.services.player.PlayerTournamentService;
import com.medianet.fishingCompetiton.services.player.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player/tournament")
@Tag(name = "Player - Tournaments", description = "Endpoints for players to view and register for tournaments")
public class PlayerTournamentController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlayerTournamentService playerTournamentService;

    @PostMapping("registrate/{tournamentId}")
    @Operation(
            summary = "Register for a tournament",
            description = "Allows a player to request registration in a tournament by providing the tournament ID"
    )
    public void registrate(
            @Parameter(description = "ID of the tournament to register for") @PathVariable int tournamentId,
            HttpServletRequest request) {
        registrationService.registrate(tournamentId, request);
    }

    @PostMapping("confirm/{registrationId}")
    @Operation(
            summary = "Confirm registration",
            description = "Allows a player to confirm their registration by using the registration ID"
    )
    public void confirmRegistration(
            @Parameter(description = "ID of the registration to confirm") @PathVariable int registrationId) {
        registrationService.confirmRegistration(registrationId);
    }

    @GetMapping
    @Operation(
            summary = "Get all tournaments",
            description = "Returns a list of all available tournaments for players to view and register"
    )
    public List<Tournament> getAllTouranments() {
        return playerTournamentService.getAllTournaments();
    }
}
