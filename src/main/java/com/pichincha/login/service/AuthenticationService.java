package com.pichincha.login.service;

import com.pichincha.login.service.dto.ResponseDto;

public interface AuthenticationService {
    ResponseDto getAuthenticationToken(String username, String password);
}
