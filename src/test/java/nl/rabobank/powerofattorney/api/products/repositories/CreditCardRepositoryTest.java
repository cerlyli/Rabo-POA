package nl.rabobank.powerofattorney.api.products.repositories;

import nl.rabobank.powerofattorney.api.products.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class CreditCardRepositoryTest {

    @Test
    public void TestAll() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId("1");

        CreditCardRepository creditCardRepository= new CreditCardRepository();
        creditCardRepository.save(creditCard);

        assertEquals(1, creditCardRepository.findAll().size());
        assertNotNull(creditCardRepository.find("1"));
    }
}