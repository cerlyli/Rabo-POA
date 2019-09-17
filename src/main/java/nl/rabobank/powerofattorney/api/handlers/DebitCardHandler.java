package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.DebitCard;
import nl.rabobank.powerofattorney.api.products.repositories.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DebitCardHandler {
    @Autowired
    DebitCardRepository debitCardRepository;

    public List<DebitCard> filter4User(String user) {
        return debitCardRepository.findAll().stream()
                .filter(DebitCard.class::isInstance)
                .map(DebitCard.class::cast)
                .filter(dc -> dc.getCardHolder().equals(user))
                .filter(dc -> dc.getStatus().equals("ACTIVE"))
                .collect(Collectors.toList());
    }
}
