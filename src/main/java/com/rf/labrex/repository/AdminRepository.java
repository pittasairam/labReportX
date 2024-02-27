package com.rf.labrex.repository;

import com.rf.labrex.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Admin findByIdentificationNumber(String number);
}
