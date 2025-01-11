package com.example.ridoy.demoAfternoood.controller;

import com.example.ridoy.demoAfternoood.entity.MonthlySummary;
import com.example.ridoy.demoAfternoood.service.MonthlySummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.ridoy.demoAfternoood.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MonthlySummaryController {

    private final MonthlySummaryService monthlySummaryService;

    @GetMapping("/api/v1/afternoon-delights/person/{personId}/month/{month}")
    public List<MonthlySummary> getMonthlySummary(@PathVariable Long personId, @PathVariable String month) {
        LocalDate localDate = LocalDate.parse(month);
        return monthlySummaryService.getMonthlySummaryByPersonIdAndMonth(personId, localDate);
    }

    @PostMapping("/api/v1/afternoon-delights/monthly-summery")
    public MonthlySummary saveMonthlySummary(@RequestBody MonthlySummary monthlySummary) {
        return monthlySummaryService.saveMonthlySummary(monthlySummary);
    }
}