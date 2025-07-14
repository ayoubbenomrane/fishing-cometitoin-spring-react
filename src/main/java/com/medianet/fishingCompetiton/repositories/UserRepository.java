package com.medianet.fishingCompetiton.repositories;

import com.medianet.fishingCompetiton.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {



    Optional<User> findByPhoneNumber(String phoneNumber) ;
    Optional<User> findByEmail(String email);
//    Optional<User> findById(int id);

    void deleteById(int id);
}
