package com.minhhuu.banhang.service;

import com.minhhuu.banhang.model.User;
import com.minhhuu.banhang.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public void save(User user){
       userRepo.save(user);
    }
    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
      return userRepo.findById(id);
    }
    public  boolean findByName(String username){
      return userRepo.findByName(username);
    }
    public  User findByAccountname(String accountname){
      return userRepo.findName(accountname);
    }

    public void update(User user) {

        userRepo.update(user);
    }

    public void deleteById(Long id) {
      userRepo.deleteById(id);
    }
}
