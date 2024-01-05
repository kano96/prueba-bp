package com.pichincha.login.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDto {
    private String user;
    private String password;

}
