package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Find all transactions for a specific person
    List<Transaction> findByPersonId(Long personId);

    // Find transactions for a person filtered by type
    List<Transaction> findByPersonIdAndType(Long personId, String type);

    // Find transactions for a person within a date range
    List<Transaction> findByPersonIdAndTransactionTimeBetween(Long personId, LocalDateTime start, LocalDateTime end);

    // Custom query to find transactions for a person filtered by type
    @Query("SELECT t FROM Transaction t WHERE t.person.id = :personId AND t.type = :type")
    List<Transaction> findTransactionsByPersonIdAndType(@Param("personId") Long personId, @Param("type") String type);

    // Calculate the total balance for a person
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.person.id = :personId")
    Double getPersonBalance(@Param("personId") Long personId);

    @Query("SELECT t FROM Transaction t WHERE t.person.id = :personId AND t.transactionTime BETWEEN :startDate AND :endDate")
    List<Transaction> filterTransactionsByDateRange(
            @Param("personId") Long personId,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

}
