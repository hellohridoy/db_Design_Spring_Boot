package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
