package com.example.ridoy.demoAfternoood.service;

import com.example.ridoy.demoAfternoood.entity.MonthlySummary;
import com.example.ridoy.demoAfternoood.repository.MonthlySummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BalanceHistoryService {
    @Autowired
    private MonthlySummaryRepository monthlySummaryRepository;

    public List<MonthlySummary> getMonthlySummaryByPersonIdAndMonth(Long personId, LocalDate month) {
        return monthlySummaryRepository.findByPersonIdAndMonth(personId, month);
    }

    public MonthlySummary saveMonthlySummary(MonthlySummary monthlySummary) {
        return monthlySummaryRepository.save(monthlySummary);
    }
}
