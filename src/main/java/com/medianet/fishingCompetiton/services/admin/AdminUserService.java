package com.medianet.fishingCompetiton.services.admin;

import com.medianet.fishingCompetiton.DTOs.user.UpdateUserDTO;
import com.medianet.fishingCompetiton.DTOs.user.UserResponseDTO;
import com.medianet.fishingCompetiton.mappers.UserMapper;
import com.medianet.fishingCompetiton.models.User;
import com.medianet.fishingCompetiton.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public User getUserById(int id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return user;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(int id,UpdateUserDTO dto) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        if(dto.getEmail()!=null){
            user.setEmail(dto.getEmail());
        }
        if(dto.getFirstName()!=null){
            user.setFirstName(dto.getFirstName());
        }
        if(dto.getLastName()!=null){
            user.setLastName(dto.getLastName());
        }
        if(dto.getPassword()!=null){
            user.setPassword(dto.getPassword());
        }
        if(dto.getProfilePicture()!=null){
            user.setProfilePicture(dto.getProfilePicture());
        }
        if(dto.getPhoneNumber()!=null){
            user.setPhoneNumber(dto.getPhoneNumber());
        }
        if(dto.getRole()!=null){
            user.setRole(dto.getRole());
        }
        userRepository.save(user);


    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    public void registrate(int touranmentId){


    }
}
