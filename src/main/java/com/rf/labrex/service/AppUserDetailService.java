package com.rf.labrex.service;

import com.rf.labrex.repository.BaseUserRepository;
import com.rf.labrex.repository.LaboratoryWorkerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {
    private final BaseUserRepository baseUserRepository;

    public AppUserDetailService(BaseUserRepository baseUserRepository, LaboratoryWorkerRepository workerRepository) {
        this.baseUserRepository = baseUserRepository;

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return baseUserRepository.findByIdentificationNumber(username).orElseThrow(() -> new UsernameNotFoundException("Kullanici Bulunamadi"));
    }
}
