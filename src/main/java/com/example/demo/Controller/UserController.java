package com.example.demo.Controller;

import com.example.demo.Dao.RoleDao;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.RoleName;
import com.example.demo.Entity.Transaction;
import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Login.LoginRequest;
import com.example.demo.Login.LoginResponse;
import com.example.demo.Security.JwtTokenProvider;
import com.example.demo.Service.MapValidationService;
import com.example.demo.Service.UserService;
import com.example.demo.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static com.example.demo.Security.SecurityConstant.TOKEN_PREFIX;
import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/users")
public class UserController {


        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private MapValidationService mapValidationService;

        @Autowired
        private UserService userService;

        @Autowired
        private JwtTokenProvider jwtTokenProvider;

        // roles feature, just in case if err, just remove this shit
        @Autowired
        private RoleDao roleDao;

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserValidator userValidator;

        @PostMapping(path = "/register")
        public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){

            userValidator.validate(user, result);

            ResponseEntity<?> errorMap = mapValidationService.MapValidationService(result);

            if (errorMap!= null)
                return errorMap;


//
//            User newUser = userService.saveUser(user);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//            Role userRole = roleDao.findByName(RoleName.ROLE_ADMIN).orElseThrow(()->new Ece);

            // just in case if err again just remove this comment lowwer side this comment
            // and just fucking delete code in upper this coomment

          User newUser = userService.saveUser(user);

           return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        }

        @PostMapping(path = "/login")
        public ResponseEntity<?> loginUser(@Valid @RequestBody  LoginRequest loginRequest, BindingResult result ){
            ResponseEntity<?> errorMap = mapValidationService.MapValidationService(result);

            if (errorMap!= null)
                return errorMap;

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()

                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt= TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);



            return ResponseEntity.ok(new LoginResponse(true, jwt));
        }

        // user api crud



}
