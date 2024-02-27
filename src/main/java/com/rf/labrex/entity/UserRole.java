package com.rf.labrex.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMİN,WORKER,PATİENT;
    @Override
    public String getAuthority() {
        return name();
    }
}
