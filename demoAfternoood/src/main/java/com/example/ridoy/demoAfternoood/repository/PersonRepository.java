package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.Person;
import com.example.ridoy.demoAfternoood.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p1_0.id, p1_0.address, p1_0.balance, p1_0.created_at, p1_0.email, p1_0.first_name, " +
            "p1_0.last_name, p1_0.phone, p1_0.profile_picture, p1_0.role, p1_0.updated_at " +
            "FROM person p1_0 " +
            "JOIN meal_cost mc1_0 ON p1_0.id = mc1_0.person_id " +
            "WHERE p1_0.id = :personId " +
            "AND extract(month FROM mc1_0.date) = :month " +
            "AND extract(year FROM mc1_0.date) = :year", nativeQuery = true)
    List<Person> findMemberHistoryByIdAndMonth(@Param("personId") Long personId,
                                               @Param("month") int month,
                                               @Param("year") int year);

    @Query("SELECT p FROM Person p JOIN p.mealCosts m " +
            "WHERE p.id = :personId AND m.date BETWEEN :startDate AND :endDate")
    List<Person> findMemberHistoryByIdAndDateRange(@Param("personId") Long personId,
                                                   @Param("startDate") LocalDateTime startDate,
                                                   @Param("endDate") LocalDateTime endDate);




}
