package com.example.ridoy.demoAfternoood.controller;

import com.example.ridoy.demoAfternoood.entity.AuditLog;
import com.example.ridoy.demoAfternoood.entity.MealCost;
import com.example.ridoy.demoAfternoood.entity.Transaction;
import com.example.ridoy.demoAfternoood.service.AuditLogService;
import com.example.ridoy.demoAfternoood.service.MealCostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class MealCostController {

    private final MealCostService mealCostService;

    @GetMapping("/api/v1/afternoon-delights/meal-infos/person/{personId}/month")
    public double getMonthlyMealCost(
            @PathVariable Long personId,
            @RequestParam YearMonth month) {
        return mealCostService.getMonthlyMealCost(personId, month);
    }

    @PostMapping("/api/v1/afternoon-delights/meal-cost-infos")
    public ResponseEntity<MealCost> addMealCost(@RequestBody MealCost mealCost) {
        MealCost savedMealCost = mealCostService.addMealCost(mealCost);
        return ResponseEntity.ok(savedMealCost);
    }


}

