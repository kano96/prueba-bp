package com.pichincha.login.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String token;
    private String message;
}
