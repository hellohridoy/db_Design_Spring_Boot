package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.BalanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceHistoryRepository extends JpaRepository<BalanceHistory, Long> {
    List<BalanceHistory> findByPersonId(Long personId);
}
