package com.example.demo.Login;

import com.example.demo.Entity.User;
import org.springframework.web.bind.annotation.ResponseBody;

public class LoginResponse {

    private boolean success;
    private String token;
    private Long userId;




    public LoginResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
        this.userId= userId;



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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                ", userId=" + userId +
                '}';
    }
}
