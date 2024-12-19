package Com.example.bankingApp.DesignDB.repository;


import Com.example.bankingApp.DesignDB.entity.Account;
import Com.example.bankingApp.DesignDB.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
