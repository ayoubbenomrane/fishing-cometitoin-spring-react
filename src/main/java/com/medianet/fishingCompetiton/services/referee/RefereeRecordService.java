package com.medianet.fishingCompetiton.services.referee;

import com.medianet.fishingCompetiton.DTOs.tournament.RecordDTO;
import com.medianet.fishingCompetiton.models.Record;
import com.medianet.fishingCompetiton.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefereeRecordService {
    @Autowired
    RecordRepository recordRepository;



    public void udpateRecord(int recordId, RecordDTO dto) {
        Record record = recordRepository.findById(recordId).orElseThrow(() -> new RuntimeException("record not found"));
        if(dto.getFishCount()!=null){
            record.setFishCount(dto.getFishCount());
        }
        if(dto.getEliminated()!=null){
            record.setEliminated(dto.getEliminated());
        }
        if(dto.getTotalWeight()!=null){
            record.setTotalWeight(dto.getTotalWeight());
        }
        if(dto.getAbsent()!=null){
            record.setAbsent(dto.getAbsent());
        }

    }


}
