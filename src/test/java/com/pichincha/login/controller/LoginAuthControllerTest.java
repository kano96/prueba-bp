package com.pichincha.login.controller;

import com.pichincha.login.service.AuthenticationService;
import com.pichincha.login.service.dto.AuthRequestDto;
import com.pichincha.login.service.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginAuthControllerTest {
    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private LoginAuthController loginAuthController;

    @Test
    public void testAuthenticateUser(){
        ResponseDto succeedResponse = new ResponseDto();
        succeedResponse.setToken("testtoken");
        succeedResponse.setMessage("éxito");
        String user = "test";
        String password = "password";
        when(authenticationService.getAuthenticationToken(user, password)).thenReturn(succeedResponse);


        AuthRequestDto authRequest = new AuthRequestDto();
        authRequest.setUser(user);
        authRequest.setPassword(password);

        ResponseEntity<ResponseDto> response = loginAuthController.authenticateUser(authRequest);

        assertNotNull(response);
        assertEquals(succeedResponse.getToken(), Objects.requireNonNull(response.getBody()).getToken());
        assertEquals(succeedResponse.getMessage(), Objects.requireNonNull(response.getBody()).getMessage());

        verify(authenticationService, times(1)).getAuthenticationToken(user, password);
    }
}
