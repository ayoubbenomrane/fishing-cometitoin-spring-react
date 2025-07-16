package com.medianet.fishingCompetiton.controllers.refereeControllers;

import com.medianet.fishingCompetiton.DTOs.tournament.RecordDTO;
import com.medianet.fishingCompetiton.services.referee.RefereeRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("referee/record")
@Tag(name = "Referee - Records", description = "Endpoints for referees to update player performance records during rounds")
public class RefereeRecordController {

    @Autowired
    RefereeRecordService refereeRecordService;

    @PutMapping("{id}")
    @Operation(
            summary = "Update player record for a round",
            description = "Allows a referee to update the score and fish data for a player’s participation in a specific round"
    )
    public void updateRecord(
            @Parameter(description = "ID of the record to update") @PathVariable int id,
            @Parameter(description = "Updated record data") @RequestBody RecordDTO dto
    ) {
        refereeRecordService.udpateRecord(id, dto);
    }
}
