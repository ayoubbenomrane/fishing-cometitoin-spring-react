package com.medianet.fishingCompetiton.services.referee;

import com.medianet.fishingCompetiton.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefereeRecordService {
    @Autowired
    RecordRepository recordRepository;



}
