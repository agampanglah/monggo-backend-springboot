package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Login.LoginRequest;
import com.example.demo.Login.LoginResponse;
import com.example.demo.Security.JwtTokenProvider;
import com.example.demo.Service.MapValidationService;
import com.example.demo.Service.UserService;
import com.example.demo.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.demo.Security.SecurityConstant.TOKEN_PREFIX;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {




        @Autowired
        private MapValidationService mapValidationService;

        @Autowired
        private UserService userService;

        @Autowired
        private JwtTokenProvider jwtTokenProvider;

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



            User newUser = userService.saveUser(user);

            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        }

        @PostMapping(path = "/login")
        public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
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
            String jwt = TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new LoginResponse(true, jwt));
        }
}
