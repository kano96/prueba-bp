package com.pichincha.login.service.impl;


import com.pichincha.login.service.dto.ResponseDto;
import com.pichincha.login.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceImplTest {
    @Mock
    private JwtUtil jwtUtil;


    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Test
    public void testGetAuthenticationToken(){
        String username = "user";
        String password = "password";
        String mockToken = "mockToken";


        when(jwtUtil.generateToken(username)).thenReturn(mockToken);

        ResponseDto responseDto = authenticationService.getAuthenticationToken(username, password);

        assertEquals("Autenticación exitosa", responseDto.getMessage());
        assertEquals(mockToken, responseDto.getToken());

    }

}
