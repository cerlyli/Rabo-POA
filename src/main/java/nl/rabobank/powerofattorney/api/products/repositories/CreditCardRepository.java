package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.CreditCard;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CreditCardRepository {
    Map<String, CreditCard> cache = new HashMap<>();

    public List<CreditCard> findAll() {
        return cache.values().stream()
                .collect(Collectors.toList());

    }

    public void save(CreditCard card) {
        cache.put(card.getId(), card);
    }

    public CreditCard find(String id) {
        return cache.get(id);
    }

}
