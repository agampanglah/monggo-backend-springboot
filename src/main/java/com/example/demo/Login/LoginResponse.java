package com.example.demo.Login;

import com.example.demo.Entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

public class LoginResponse {

    private boolean success;
    private String token;
    private Object user;




    public LoginResponse(boolean success, String token, Objects user) {
        this.success = success;
        this.token = token;
        this.user = user;




    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
