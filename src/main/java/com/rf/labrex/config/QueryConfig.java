package com.rf.labrex.config;

import com.rf.labrex.entity.BaseUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class QueryConfig {
    public BaseUser getAuthentication(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        BaseUser user =(BaseUser) authentication.getPrincipal();
        return user;
    }
    public boolean isAuthorized(BaseUser authenticate,BaseUser request){
        return authenticate.getId().equals(request.getId());
    }
}
