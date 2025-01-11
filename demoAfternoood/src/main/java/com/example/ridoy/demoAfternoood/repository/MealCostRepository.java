package com.example.ridoy.demoAfternoood.repository;

import com.example.ridoy.demoAfternoood.entity.MealCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface MealCostRepository extends JpaRepository<MealCost, Long> {
    //Collection<Object> findByPersonIdAndDateBetween(Long personId, LocalDate start, LocalDate end);
    //List<MealCost> findByPersonIdAndDateBetween(Long personId, LocalDate start, LocalDate end);
    List<MealCost> findByPerson_IdAndDateBetween(Long personId, LocalDate startDate, LocalDate endDate);

    //List<MealCost> findByPersonIdAndDateBetween(Long personId, LocalDate startDate, LocalDate endDate);

}
