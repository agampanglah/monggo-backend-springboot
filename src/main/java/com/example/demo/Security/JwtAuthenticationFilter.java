package com.example.demo.Security;

import com.example.demo.Entity.User;
import com.example.demo.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.demo.Security.SecurityConstant.HEADER_STRING;
import static com.example.demo.Security.SecurityConstant.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwt = getJwtfromLoginResquest(httpServletRequest);

            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
                Long userId = jwtTokenProvider.getUserId(jwt);

                User userDetails = customUserDetailService.loadUserById(userId);
            }
        } catch (Exception ex) {
            logger.error("couldn't  set user, ", ex);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private String getJwtfromLoginResquest(HttpServletRequest httpServletRequest) {

        String bearerToken = httpServletRequest.getHeader(HEADER_STRING);

        if (StringUtils.hasText(bearerToken)&&bearerToken.startsWith(TOKEN_PREFIX)){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    }

