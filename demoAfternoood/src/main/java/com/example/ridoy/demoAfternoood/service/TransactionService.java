package com.example.ridoy.demoAfternoood.service;

import com.example.ridoy.demoAfternoood.entity.Person;
import com.example.ridoy.demoAfternoood.entity.Transaction;
import com.example.ridoy.demoAfternoood.repository.PersonRepository;
import com.example.ridoy.demoAfternoood.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Double getPersonBalance(Long personId) {
        // Logic to calculate balance based on transactions
        return transactionRepository.getPersonBalance(personId);
    }

    public List<Transaction> filterTransactionsByType(Long personId, String type) {
        return transactionRepository.findByPersonIdAndType(personId, type);
    }

    public List<Transaction> filterTransactionsByDateRange(Long personId, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.filterTransactionsByDateRange(personId, startDate, endDate);
    }


//    public double getTransactionSummary(Long personId, String type) {
//        return transactionRepository.findByPersonIdAndType(personId, type)
//                .stream()
//                .mapToDouble(Transaction::getPersonBalance)
//                .sum();
//    }


    public List<Transaction> getTransactionsByPersonId(Long personId) {
        return transactionRepository.findByPersonId(personId);
    }

    public List<Transaction> getTransactionsByType(Long personId, String type) {
        return transactionRepository.findByPersonIdAndType(personId, type);
    }
}
