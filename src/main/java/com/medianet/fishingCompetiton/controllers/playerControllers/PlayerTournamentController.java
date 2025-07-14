package com.medianet.fishingCompetiton.controllers.playerControllers;

import com.medianet.fishingCompetiton.models.Round;
import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.repositories.UserRepository;
import com.medianet.fishingCompetiton.services.player.PlayerTournamentService;
import com.medianet.fishingCompetiton.services.player.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player/tournament")
public class PlayerTournamentController {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PlayerTournamentService playerTournamentService;
    @PostMapping("registrate/{tournamentId}")
    void registrate(@PathVariable int tournamentId , HttpServletRequest request){
        registrationService.registrate(tournamentId,request);
    }

    @PostMapping("confirm/{registrationId}")
    void confirmRegistration(@PathVariable int registrationId){
        registrationService.confirmRegistration(registrationId);
    }
    @GetMapping()
    List<Tournament> getAllTouranments(){
        return playerTournamentService.getAllTournaments();
    }
}
