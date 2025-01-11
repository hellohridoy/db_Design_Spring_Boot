package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.BalanceHistory;
import com.example.ridoy.demoAfternoood.entity.MonthlySummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MonthlySummaryRepository extends JpaRepository<MonthlySummary, Long> {
    List<MonthlySummary> findByPersonIdAndMonth(Long personId, LocalDate month);
}
