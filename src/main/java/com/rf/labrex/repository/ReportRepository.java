package com.rf.labrex.repository;

import com.rf.labrex.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,String> {
}
