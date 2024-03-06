package com.rf.labrex.service;

import com.rf.labrex.dto.AuthDto;
import com.rf.labrex.dto.AuthRequest;
import com.rf.labrex.dto.BaseUserDto;
import com.rf.labrex.dto.converter.DtoConverter;
import com.rf.labrex.entity.BaseUser;
import com.rf.labrex.entity.Token;
import com.rf.labrex.exception.AuthException;
import com.rf.labrex.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenService tokenService;
    private final AppUserService appUserService;
    private final PasswordEncoder encoder;
    private final DtoConverter converter;

    public AuthDto login(AuthRequest request) {
        BaseUser user =appUserService.findByIdentificationNumber(request.getIdentificationNumber());
        if(!encoder.matches(request.getPassword(), user.getPassword())) throw new AuthException();
        Token token=tokenService.createToken(user);
        AuthDto authDto=AuthDto.builder().token(token.getToken()).user(converter.convertUser(user)).build();
        return authDto;
    }
    public void logout(String cookie){
        tokenService.logout(cookie);
    }

    public BaseUserDto verifyToken(String cookie) {
        BaseUser baseUser=tokenService.verifyToken(cookie);
        if(baseUser==null){
            throw new InvalidTokenException();
        }
        return converter.convertUser(baseUser);
    }
}
