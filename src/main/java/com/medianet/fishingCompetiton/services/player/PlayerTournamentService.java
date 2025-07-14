package com.medianet.fishingCompetiton.services.player;


import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerTournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    public List<Tournament> getAllTournaments(){
        return tournamentRepository.findAll();
    }

}
