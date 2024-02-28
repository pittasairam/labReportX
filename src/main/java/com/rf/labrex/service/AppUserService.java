package com.rf.labrex.service;

import com.rf.labrex.entity.BaseUser;
import com.rf.labrex.exception.NotFoundException;
import com.rf.labrex.repository.BaseUserRepository;
import com.rf.labrex.repository.LaboratoryWorkerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    private final BaseUserRepository baseUserRepository;

    public AppUserService(BaseUserRepository baseUserRepository, LaboratoryWorkerRepository workerRepository) {
        this.baseUserRepository = baseUserRepository;

    }

    protected BaseUser findByIdentificationNumber(String number){
        return baseUserRepository.findByIdentificationNumber(number).orElseThrow(()->new NotFoundException(number+" Numaralı Kullanici"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByIdentificationNumber(username);
    }
}
