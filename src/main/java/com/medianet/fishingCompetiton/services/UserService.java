package com.medianet.fishingCompetiton.services;

import com.medianet.fishingCompetiton.DAOs.UserDao;
import com.medianet.fishingCompetiton.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao){
        this.userDao=userDao;
    }

    public User getUserById(int id) {
        return userDao.findById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public void createUser(User user) {
        userDao.save(user);
    }

    public User updateUser(User user) {
        return userDao.update(user);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }
}
