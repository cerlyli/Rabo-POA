package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.DebitCard;
import nl.rabobank.powerofattorney.api.products.Poa;
import org.junit.Test;

import static org.junit.Assert.*;

public class PoaRepositoryTest {
    @Test
    public void TestAll() {
        Poa poa= new Poa();
        PoaRepository poaRepository = new PoaRepository();
        poaRepository.save(poa);
        assertNotNull(poaRepository.findAll());
    }


}