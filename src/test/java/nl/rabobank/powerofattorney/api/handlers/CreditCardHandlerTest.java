package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.CreditCard;
import nl.rabobank.powerofattorney.api.products.repositories.CreditCardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class CreditCardHandlerTest {
    @Mock
    private CreditCardRepository accountRepository;
    @InjectMocks
    private CreditCardHandler creditCardHandler;

    @Test
    public void testActiveCard() {
        CreditCard dummyCreditCard = new CreditCard();
        dummyCreditCard.setCardHolder("Dummy User");
        dummyCreditCard.setStatus("ACTIVE");
        List<CreditCard> creditcardList = new ArrayList<>();
        creditcardList.add(dummyCreditCard);
        when(accountRepository.findAll()).thenReturn(creditcardList);

        List<CreditCard> list = creditCardHandler.filter4User("Dummy User");
        assertEquals(1, list.size());
    }

    @Test
    public void testNonActiveCard() {
        CreditCard dummyCreditCard = new CreditCard();
        dummyCreditCard.setCardHolder("Dummy User");
        dummyCreditCard.setStatus("BLOCKED");
        List<CreditCard> creditcardList = new ArrayList<>();
        creditcardList.add(dummyCreditCard);
        when(accountRepository.findAll()).thenReturn(creditcardList);

        List<CreditCard> list = creditCardHandler.filter4User("Dummy User");
        assertEquals(0, list.size());
    }
}