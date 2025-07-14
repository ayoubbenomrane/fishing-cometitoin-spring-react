package com.medianet.fishingCompetiton.repositories;

import com.medianet.fishingCompetiton.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Integer> {
}
