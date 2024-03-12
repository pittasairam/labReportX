package com.rf.labrex.service;

import com.rf.labrex.entity.BaseUser;
import com.rf.labrex.entity.Token;
import com.rf.labrex.exception.InvalidTokenException;
import com.rf.labrex.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

// token işlemleri
@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    // create token
    public Token createToken(BaseUser user){
        String tok= UUID.randomUUID().toString();
        Token token=Token.builder().token(tok).baseUser(user).build();
        tokenRepository.save(token);
        return token;
    }
    // valid token
    public BaseUser verifyToken(String token){
        Token db=getToken(token);
        return db.getBaseUser();
    }
    // delete token - logout
    public void logout(String token){
        Token db=getToken(token);
        tokenRepository.delete(db);
    }
    // token alma
    private Token getToken(String token){
        return tokenRepository.findById(token).orElseThrow(()->new InvalidTokenException());
    }
}
