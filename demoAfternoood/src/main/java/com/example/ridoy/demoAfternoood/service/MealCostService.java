package com.example.ridoy.demoAfternoood.service;

import com.example.ridoy.demoAfternoood.entity.MealCost;
import com.example.ridoy.demoAfternoood.enums.Operations;
import com.example.ridoy.demoAfternoood.repository.MealCostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
@Transactional
@RequiredArgsConstructor
public class MealCostService {

    private final MealCostRepository mealCostRepository;
    private final AuditLogService auditLogService;

    public double getMonthlyMealCost(Long personId, YearMonth month) {
        LocalDate start = month.atDay(1);
        LocalDate end = month.atEndOfMonth();
        return mealCostRepository.findByPerson_IdAndDateBetween(personId, start, end)
                .stream()
                .mapToDouble(MealCost::getTotalCost)
                .sum();
    }

    @Transactional
    public MealCost addMealCost(MealCost mealCost) {
        // Save the meal cost
        MealCost savedMealCost = mealCostRepository.save(mealCost);

        // Log the operation using AuditLogService
        auditLogService.logOperation(
                mealCost.getPerson(),
                Operations.ADD_MEAL_COST,
                "Added meal cost for " + mealCost.getDate()
        );

        return savedMealCost;
    }
}
