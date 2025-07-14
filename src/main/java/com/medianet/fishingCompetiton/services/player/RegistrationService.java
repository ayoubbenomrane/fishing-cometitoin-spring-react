package com.medianet.fishingCompetiton.services.player;

import com.medianet.fishingCompetiton.jwt.JwtUtils;
import com.medianet.fishingCompetiton.models.Registration;
import com.medianet.fishingCompetiton.models.Tournament;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.repositories.RegistrationRepository;
import com.medianet.fishingCompetiton.repositories.TournamentRepository;
import com.medianet.fishingCompetiton.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    JwtUtils jwtUtils;
    public void registrate(int tournamentId , HttpServletRequest request){
        String token= jwtUtils.getJwtFromHeader(request);
        String email= jwtUtils.getUserNameFromJwtToken(token);
        User user= userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("ERROR"));
        Tournament tournament= tournamentRepository.findById(tournamentId).orElseThrow(()->new RuntimeException("tournaùent not found"));
        Registration registration = new Registration(tournament,user);
        registrationRepository.save(registration);

    }
    public void confirmRegistration(int registrationId){
        Registration registration=registrationRepository.findById(registrationId).orElseThrow(()->new RuntimeException("registration not found"));
        registration.setConfirmation(true);
    }
}
