package com.rf.labrex.repository;

import com.rf.labrex.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,String> {
}
