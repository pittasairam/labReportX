package com.rf.labrex.dto;

import com.rf.labrex.entity.BaseUser;
import com.rf.labrex.entity.Token;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDto {
    private  Token token;
    private BaseUserDto user;
}
