package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.DebitCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class DebitCardRepositoryTest {

    @Test
    public void TestAll() {
        DebitCard debitCard = new DebitCard();
        debitCard.setId("1");

        DebitCardRepository debitCardRepository = new DebitCardRepository();
        debitCardRepository.save(debitCard);

        assertEquals(1, debitCardRepository.findAll().size());
        assertNotNull(debitCardRepository.find("1"));
    }

}