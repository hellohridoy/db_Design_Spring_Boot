package com.example.ridoy.demoAfternoood.controller;

import com.example.ridoy.demoAfternoood.entity.Transaction;
import com.example.ridoy.demoAfternoood.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/api/v1/afternoon-delights/transaction-infos")
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/api/v1/afternoon-delights/transaction-infos/balance/{personId}")
    public Double getPersonBalance(@PathVariable Long personId) {
        return transactionService.getPersonBalance(personId);
    }

    @GetMapping("/api/v1/afternoon-delights/transaction-infos/filter/{personId}/type/{type}")
    public List<Transaction> filterTransactionsByType(@PathVariable Long personId, @PathVariable String type) {
        return transactionService.filterTransactionsByType(personId, type);
    }

    @GetMapping("/api/v1/afternoon-delights/transaction-infos/filter/{personId}/start/{startDate}/end/{endDate}")
    public List<Transaction> filterTransactionsByDateRange(@PathVariable Long personId,
                                                           @PathVariable String startDate,
                                                           @PathVariable String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return transactionService.filterTransactionsByDateRange(personId, start, end);
    }

    @GetMapping("/api/v1/afternoon-delights/transaction-infos/person/{personId}")
    public List<Transaction> getTransactionsByPersonId(@PathVariable Long personId) {
        return transactionService.getTransactionsByPersonId(personId);
    }

    @GetMapping("/api/v1/afternoon-delights/transaction-infos/person/{personId}/type/{type}")
    public List<Transaction> getTransactionsByType(@PathVariable Long personId, @PathVariable String type) {
        return transactionService.getTransactionsByType(personId, type);
    }

}
