package com.medianet.fishingCompetiton.controllers.adminControllers;

import com.medianet.fishingCompetiton.models.Round;
import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.services.admin.TournamentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/tournament")
@Tag(name = "Admin - Tournament Management", description = "Endpoints for creating, updating, and managing tournaments and rounds")
public class AdminTournamentController {

    @Autowired
    TournamentService tournamentService;

    @GetMapping()
    @Operation(summary = "Get all tournaments", description = "Retrieve a list of all fishing tournaments.")
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get tournament by ID", description = "Retrieve detailed information of a specific tournament.")
    public Tournament getTournamentById(
            @Parameter(description = "ID of the tournament") @PathVariable int id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping()
    @Operation(summary = "Create a new tournament", description = "Create a new tournament with name, description, and duration.")
    public void createTournament(
            @Parameter(description = "Tournament object to create") @RequestBody Tournament tournament) {
        tournamentService.createTournament(tournament);
    }

    @PutMapping("{id}")
    @Operation(summary = "Update a tournament", description = "Update details of an existing tournament by ID.")
    public void updateTournament(
            @Parameter(description = "ID of the tournament to update") @PathVariable int id,
            @Parameter(description = "Updated tournament object") @RequestBody Tournament tournament) {
        tournamentService.updateTournament(tournament, id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a tournament", description = "Delete a tournament by its ID.")
    public void deleteTournament(
            @Parameter(description = "ID of the tournament to delete") @PathVariable int id) {
        tournamentService.deleteTournament(id);
    }

    @PostMapping("round/{tournamentId}")
    @Operation(summary = "Create a new round", description = "Create a round and assign it to a specific tournament.")
    public void createRound(
            @Parameter(description = "ID of the tournament to assign the round to") @PathVariable int tournamentId,
            @Parameter(description = "Round object to create") @RequestBody Round round) {
        tournamentService.createRound(tournamentId, round);
    }

    @DeleteMapping("round/{roundId}")
    @Operation(summary = "Delete a round", description = "Remove a round from the system by its ID.")
    public void deleteRound(
            @Parameter(description = "ID of the round to delete") @PathVariable int roundId) {
        tournamentService.deleteRound(roundId);
    }

    @PutMapping("round/{roundId}")
    @Operation(summary = "Update a round", description = "Update the details of an existing round by its ID.")
    public void updateRound(
            @Parameter(description = "ID of the round to update") @PathVariable int roundId,
            @Parameter(description = "Updated round object") @RequestBody Round round) {
        tournamentService.updateRound(roundId, round);
    }
}
