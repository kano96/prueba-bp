package com.pichincha.login.controller;

import com.pichincha.login.service.dto.AuthRequestDto;
import com.pichincha.login.service.dto.ResponseDto;
import com.pichincha.login.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@RequiredArgsConstructor
public class LoginAuthController {
    private JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> authenticate(@RequestBody AuthRequestDto authRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUser(), authRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtil.generateToken(authRequest.getUser());

        ResponseDto response = new ResponseDto();
        response.setMessage("Autenticación exitosa");
        response.setToken(token);

        return ResponseEntity.ok(response);
    }
}
