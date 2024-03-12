package com.rf.labrex.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDto {
    private  String token;
    private BaseUserDto user;
}
