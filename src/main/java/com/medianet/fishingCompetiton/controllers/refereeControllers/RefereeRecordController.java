package com.medianet.fishingCompetiton.controllers.refereeControllers;


import com.medianet.fishingCompetiton.DTOs.tournament.RecordDTO;
import com.medianet.fishingCompetiton.services.referee.RefereeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("referee/record")
public class RefereeRecordController {
    @Autowired
    RefereeRecordService refereeRecordService;
    



    @PutMapping("{id}")
    void updateRecord(@PathVariable int id, @RequestBody RecordDTO dto ){
        refereeRecordService.udpateRecord(id, dto);
    }
}
