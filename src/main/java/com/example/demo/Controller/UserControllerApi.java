package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class UserControllerApi {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> getUserAll(){
        return userService.getUserAll();
    }

    @RequestMapping(path = "/user/{user_id}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable(value = "user_id") Long user_id){
        return userService.getUserId(user_id);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(path = "/user/{user_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUserById(@PathVariable(value = "user_id") Long user_id, @RequestBody User user){
        return userService.updateUserById(user_id, user);
    }

    @RequestMapping(path = "/user/{user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUserById(@PathVariable(value = "user_id") Long user_id){
        return userService.deleteById(user_id);
    }
}
