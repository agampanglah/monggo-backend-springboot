package com.example.demo.Security;

public class SecurityConstant {

    public static final String SIGN_UP_URL = "/api/users/**";
    public static final String SECRET = "SecretKeyTokenJWT";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRED_TIME = 300_000;
}
