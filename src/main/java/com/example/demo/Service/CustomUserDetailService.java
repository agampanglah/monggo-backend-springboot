package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
        User user = userDao.findByUsername(username);

        if (user == null) new UsernameNotFoundException("user not found");
        return user;

    }

    @Transactional
    public User loadUserById (Long id) {
        User user = userDao.getById(id);
        if (user==null) new UsernameNotFoundException( "user not found");
        return user;
    }
}
