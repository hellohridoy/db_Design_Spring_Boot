package Com.example.bankingApp.DesignDB.service;

import Com.example.bankingApp.DesignDB.entity.Bank;
import Com.example.bankingApp.DesignDB.repository.BankRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBankById(Long id) {
        return bankRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank not found"));
    }

    @Override
    public Bank createBank(@Valid Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(Long id, @Valid Bank bank) {
        Bank existingBank = getBankById(id);
        existingBank.setName(bank.getName());
        existingBank.setHeadOfficeAddress(bank.getHeadOfficeAddress());
        existingBank.setEstablishedDate(bank.getEstablishedDate());
        return bankRepository.save(existingBank);
    }

    @Override
    public void deleteBank(Long id) {
        Bank bank = getBankById(id);
        bankRepository.delete(bank);
    }
}
