package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.CreditCard;
import nl.rabobank.powerofattorney.api.products.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditCardHandler {
    @Autowired
    CreditCardRepository creditCardRepository;

    public List<CreditCard> filter4User(String user) {
        return creditCardRepository.findAll().stream()

                .filter(CreditCard.class::isInstance)
                .map(CreditCard.class::cast)
                .filter(cc -> cc.getCardHolder().equals(user))
                .filter(cc -> cc.getStatus().equals("ACTIVE"))
                .collect(Collectors.toList());
    }
}
