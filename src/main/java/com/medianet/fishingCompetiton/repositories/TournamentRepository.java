package com.medianet.fishingCompetiton.repositories;

import com.medianet.fishingCompetiton.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

}
