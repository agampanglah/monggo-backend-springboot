package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser) {
        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

//            newUser.setUsername(newUser.getUsername());

            newUser.setConfirmPassword("");

            return userDao.save(newUser);
        }

        catch (Exception e) {
            throw new UsernameAlreadyExistException("username " + newUser.getUsername()+ " already exist ");
        }
    }
}
