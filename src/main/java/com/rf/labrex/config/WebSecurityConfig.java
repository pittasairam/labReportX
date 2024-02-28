package com.rf.labrex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/*
-------------HERKESE AÇIK--------------------------------------
api/v1/auth/**
api/v1/patient/save
--------------SADECE ADMİN--------------------------------
api/v1/hospital/**
api/v1/worker/**
----------------ADMİN VE LABORANT-------------------------------
api/v1/patient/list
---------------ADMİN VE HASTA--------------------------------------
api/v1/patient/delete/{id}
---------------------------------------------------------------------
--------------SADECE LABORANT-------------------------------------
api/v1/report/save/**
api/v1/report/update/{id}
api/v1/report/delete/{id}
api/v1/report/list/worker/{workerId}
api/v1/report/sort/worker/{workerId}
---------------HASTA VE LABORANT------------------------------------
api/v1/report/list/worker/{patientId}
api/v1/report/{id}
api/v1/report/search/{value}
api/v1/report/sort/patient/**
-------------------------------------------------------------------------------
 */
@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(x->x.disable());
        http.headers(x->x.disable());
        http.sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
