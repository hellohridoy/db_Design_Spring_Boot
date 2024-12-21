package Com.example.bankingApp.DesignDB.controller;

import Com.example.bankingApp.DesignDB.entity.Bank;
import Com.example.bankingApp.DesignDB.service.BankService;
import Com.example.bankingApp.DesignDB.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequiredArgsConstructor
public class BankRestController {

    private final BankService bankService;

    @GetMapping("/api/v1/bank/bank-info")
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.getAllBanks();
        return ResponseEntity.ok(banks);
    }

    @GetMapping("/api/v1/bank/bank-info/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable Long id) {
        Bank bank = bankService.getBankById(id);
        return ResponseEntity.ok(bank);
    }

    @PostMapping("/api/v1/bank/bank-info")
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankService.createBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);
    }

    @PutMapping("/api/v1/bank/bank-info/{id}")
    public ResponseEntity<?> updateBank(@PathVariable Long id, @RequestBody Bank bank) {
        Bank updatedBank = bankService.updateBank(id, bank);
        return ResponseEntity.ok(updatedBank);
    }

    @DeleteMapping("/api/v1/bank/bank-info/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
        bankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }
}
