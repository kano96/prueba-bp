package com.pichincha.login.service.impl;

import com.pichincha.login.service.AuthenticationService;
import com.pichincha.login.service.dto.ResponseDto;
import com.pichincha.login.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;
    @Override
    public ResponseDto getAuthenticationToken(String username, String password){
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(username, password);

        SecurityContextHolder.getContext().setAuthentication(authenticationRequest);

        String token = jwtUtil.generateToken(username);

        ResponseDto response = new ResponseDto();
        response.setMessage("Autenticación exitosa");
        response.setToken(token);

        return response;
    }
}
