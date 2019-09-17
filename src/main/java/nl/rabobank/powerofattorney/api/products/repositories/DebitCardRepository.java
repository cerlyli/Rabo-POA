package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.DebitCard;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DebitCardRepository {
    Map<String, DebitCard> cache = new HashMap<>();

    public List<DebitCard> findAll() {
        return cache.values().stream()
                .collect(Collectors.toList());
    }

    public void save(DebitCard debitCard) {
        cache.put(debitCard.getId(), debitCard);
    }

    public DebitCard find(String id) {
        return cache.get(id);
    }

}
