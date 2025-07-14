package com.medianet.fishingCompetiton.mappers;

import com.medianet.fishingCompetiton.DTOs.user.PlayerResponseDTO;
import com.medianet.fishingCompetiton.DTOs.user.UserResponseDTO;
import com.medianet.fishingCompetiton.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Component

public class UserMapper {
    public UserResponseDTO apply(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getProfilePicture(),
                user.getRole()
        );
    }
}
