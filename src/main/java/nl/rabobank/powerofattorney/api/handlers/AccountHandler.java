package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.Account;
import nl.rabobank.powerofattorney.api.products.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHandler {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> filter4User(String user) {
        return accountRepository.findAll().stream()
                .filter(Account.class::isInstance)
                .map(Account.class::cast)
                .filter(ac -> ac.getOwner().equals(user))
                .filter(ac -> ac.getEnded() == null)
                .collect(Collectors.toList());
    }
}
