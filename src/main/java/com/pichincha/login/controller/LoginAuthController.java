package com.pichincha.login.controller;

import com.pichincha.login.service.AuthenticationService;
import com.pichincha.login.service.dto.AuthRequestDto;
import com.pichincha.login.service.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginAuthController {

    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public ResponseEntity<ResponseDto> authenticateUser(@RequestBody AuthRequestDto authRequest){
            ResponseDto response = authenticationService.getAuthenticationToken(authRequest.getUser(), authRequest.getPassword());
            return ResponseEntity.ok(response);
    }
}
