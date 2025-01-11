package com.example.ridoy.demoAfternoood.service;

import com.example.ridoy.demoAfternoood.entity.AuditLog;
import com.example.ridoy.demoAfternoood.entity.MealCost;
import com.example.ridoy.demoAfternoood.enums.Operations;
import com.example.ridoy.demoAfternoood.entity.Person;
import com.example.ridoy.demoAfternoood.repository.AuditLogRepository;
import com.example.ridoy.demoAfternoood.repository.MealCostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuditLogService {

    private final MealCostRepository mealCostRepository;
    private final AuditLogRepository auditLogRepository;

    @Transactional
    public MealCost addMealCost(MealCost mealCost) {
        MealCost savedMealCost = mealCostRepository.save(mealCost);
        AuditLog log = new AuditLog();
        log.setPerson(mealCost.getPerson());
        log.setOperation(Operations.ADD_MEAL_COST);
        log.setTimestamp(LocalDateTime.now());
        log.setDescription("Added meal cost for " + mealCost.getDate());
        auditLogRepository.save(log);
        return savedMealCost;
    }

    public List<AuditLog> getLogsByPerson(Long personId) {
        return auditLogRepository.findByPersonId(personId);
    }

    public List<AuditLog> getLogsByOperation(Operations operation) {
        return auditLogRepository.findByOperation(operation);
    }

    public void logOperation(Person person, Operations operation, String description) {
        AuditLog auditLog = new AuditLog();
        auditLog.setPerson(person);
        auditLog.setOperation(operation);
        auditLog.setDescription(description);
        auditLog.setTimestamp(LocalDateTime.now());
        auditLogRepository.save(auditLog);
    }

}
