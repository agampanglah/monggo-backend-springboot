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

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserId(id);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUserById(@PathVariable(value = "id") Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUserById(@PathVariable(value = "id") Long id){
        return userService.deleteById(id);
    }
}
