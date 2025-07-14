package com.medianet.fishingCompetiton.mappers;

import com.medianet.fishingCompetiton.DTOs.user.PlayerResponseDTO;
import com.medianet.fishingCompetiton.models.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class PlayerMapper {

    public PlayerResponseDTO apply(User user){
        return new PlayerResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getProfilePicture()
        );
    }

}
