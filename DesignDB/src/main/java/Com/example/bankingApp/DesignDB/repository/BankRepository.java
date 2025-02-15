package Com.example.bankingApp.DesignDB.repository;

import Com.example.bankingApp.DesignDB.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
