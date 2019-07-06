package com.example.demo.Validator;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator  {

    @Override
    public boolean supports(Class<?> aClass) {
//        return false;

        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {


        User user = (User) object;

        if(user.getPassword().length() < 6){
            errors.rejectValue("password", "length", "password atleast 6 character");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "match", "password must be match" );
        }

    }
}
