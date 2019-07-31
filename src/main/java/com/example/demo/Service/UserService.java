package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.Transaction;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // user crud!! this is for admin(user admin)

    public List<User> getUserAll(){
        return userDao.findAll();
    }

    public Optional<User> getUserId(Long id) {
        if (userDao.existsById(id)) {

            return userDao.findById(id);
        }
        else{
            throw new ResourceNotFoundException("user  dengan " + id + "tidak ditemukan");
        }

    }

    public User createUser(User user){
        return userDao.save(user);
    }

    public User updateUserById(Long id, User userRequest){
        if (!userDao.existsById(id)){
            throw new ResourceNotFoundException("user dengan"  + id + "tidak ditemukan");
        }

        Optional<User> user = userDao.findById(id);

        if (!(user.isPresent())){
            throw new ResourceNotFoundException("user dengan"  + id + "tidak ditemukan");
        }

        User user1 = user.get();
        user1.setId(userRequest.getId());
        user1.setFullname(userRequest.getFullname());
        user1.setUsername(userRequest.getUsername());
        user1.setEmail(userRequest.getEmail());
        user1.setAlamat(userRequest.getAlamat());
        user1.setNo_identitas(userRequest.getAlamat());
        user1.setGender(userRequest.getGender());
        user1.setNo_telepon(userRequest.getNo_telepon());
        user1.setPassword(userRequest.getPassword());
        user1.setFoto(userRequest.getFoto());
        user1.setRole(userRequest.getRole());


        return userDao.save(user1);
    }

    public ResponseEntity<Object> deleteById(Long user_id){
        if (!userDao.existsById(user_id)){
            throw new ResourceNotFoundException("user dengan"  + user_id + "tidak ditemukan");
        }

        userDao.deleteById(user_id);
        return ResponseEntity.ok().build();
    }
}
