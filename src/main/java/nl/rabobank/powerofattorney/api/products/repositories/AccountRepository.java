package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.Account;
import org.springframework.data.jpa.repository.JpaRepository;


//Here playing with JPA in-memory cache for plain json object
public interface AccountRepository extends JpaRepository<Account, Long> {
}
