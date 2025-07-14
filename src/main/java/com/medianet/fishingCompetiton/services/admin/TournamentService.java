package com.medianet.fishingCompetiton.services.admin;

import com.medianet.fishingCompetiton.models.Registration;
import com.medianet.fishingCompetiton.models.Round;
import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.repositories.RecordRepository;
import com.medianet.fishingCompetiton.repositories.RegistrationRepository;
import com.medianet.fishingCompetiton.repositories.RoundRepository;
import com.medianet.fishingCompetiton.repositories.TournamentRepository;
import com.medianet.fishingCompetiton.models.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    RoundRepository roundRepository;
    @Autowired
    RegistrationRepository registrationRepository;

    public Tournament getTournamentById(int id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new RuntimeException("tournament not found"));
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public void createTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public void deleteTournament(int id) {
        tournamentRepository.deleteById(id);
    }

    public void updateTournament(Tournament update, int id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new RuntimeException("tournament not found"));
        if (update.getName() != null) {
            tournament.setName(update.getName());
        }
        if (update.getDescription() != null) {
            tournament.setDescription(update.getDescription());
        }
        if (update.getFinishDate() != null) {
            tournament.setFinishDate(update.getFinishDate());
        }
        if (update.getStartDate() != null) {
            tournament.setStartDate(update.getStartDate());
        }
        if (update.getRegistrationDeadLine() != null) {
            tournament.setRegistrationDeadLine(update.getRegistrationDeadLine());
        }

    }

    public void createRound(int tournamentId, Round round) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException("tournament not found"));
        round.setTournament(tournament);
        roundRepository.save(round);
        List<Registration> registrations = registrationRepository.findByTournamentAndConfirmationTrue(tournament);

        List<Record> records = registrations.stream().map(reg -> {
            return new Record(reg.getUser(),round);
        }).toList();
        recordRepository.saveAll(records);


    }
    public void deleteRound(int roundId){
        roundRepository.deleteById(roundId);
    }
    public void updateRound(int roundId,Round update){
        Round round=roundRepository.findById(roundId).orElseThrow(()->new RuntimeException("round not found"));
        if(update.getDate()!=null){
            round.setDate(update.getDate());
        }
        if(update.getName()!=null){
            round.setName(update.getName());
        }
        if(update.getDuration()!=null){
            round.setDuration(update.getDuration());
        }
        if(update.getPlace()!=null){
            round.setPlace(update.getPlace());
        }
        roundRepository.save(round);

    }

}
