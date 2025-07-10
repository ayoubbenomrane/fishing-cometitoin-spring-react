package com.medianet.fishingCompetiton.DAOs;

import com.medianet.fishingCompetiton.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserDao {

    User findById(int id);
    List<User> findAll();
    void save(User user);
    void delete(int id);
    User update(User user);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
