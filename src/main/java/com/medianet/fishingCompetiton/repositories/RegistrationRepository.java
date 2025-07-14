package com.medianet.fishingCompetiton.repositories;

import com.medianet.fishingCompetiton.models.Registration;
import com.medianet.fishingCompetiton.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
    List<Registration> findByTournamentAndConfirmationTrue(Tournament tournament);
}
