package com.rf.labrex.repository;

import com.rf.labrex.entity.BaseUser;
import com.rf.labrex.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token,String> {

}
