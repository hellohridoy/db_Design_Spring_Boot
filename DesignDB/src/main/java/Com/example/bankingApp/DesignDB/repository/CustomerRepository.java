package Com.example.bankingApp.DesignDB.repository;


import Com.example.bankingApp.DesignDB.entity.Branch;
import Com.example.bankingApp.DesignDB.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
