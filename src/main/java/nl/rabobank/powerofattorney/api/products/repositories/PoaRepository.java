package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.Poa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PoaRepository {
    List<Poa> cache = new ArrayList();

    public List<Poa> findAll() {
        return cache;
    }

    public void save(Poa poa) {
        cache.add(poa);
    }

}
