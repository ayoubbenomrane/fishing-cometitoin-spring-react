package com.medianet.fishingCompetiton.controllers.adminControllers;

import com.medianet.fishingCompetiton.models.Round;
import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.services.admin.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/tournament")
public class AdminTournamentController {
    @Autowired
    TournamentService tournamentService;

    @GetMapping()
    List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournaments();
    }
    @GetMapping("{id}")
    Tournament getTournamentById(@PathVariable int id){
        return tournamentService.getTournamentById(id);
    }
    @PostMapping()
    void createTournament(@RequestBody Tournament tournament){
        tournamentService.createTournament(tournament);
    }
    @PutMapping("{id}")
    void updateTournament(@PathVariable int id,@RequestBody Tournament tournament){
        tournamentService.updateTournament(tournament,id);
    }
    @DeleteMapping("{id}")
    void deleteTournament(@PathVariable int id){
        tournamentService.deleteTournament(id);
    }

    @PostMapping("round/{tournamentId}")
    void createRound(@PathVariable int tournamentId, @RequestBody Round round){
        tournamentService.createRound(tournamentId,round);

    }
    @DeleteMapping("round/{roundId}")
    void deleteRound(@PathVariable int roundId){
        tournamentService.deleteRound(roundId);
    }
    @PutMapping("round/{roundId}")
    void updateRound(@PathVariable int roundId, @RequestBody Round round ){
        tournamentService.updateRound(roundId,round);
    }


}
