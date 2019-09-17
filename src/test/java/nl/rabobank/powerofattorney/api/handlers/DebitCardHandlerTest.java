package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.DebitCard;
import nl.rabobank.powerofattorney.api.products.repositories.DebitCardRepository;
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
public class DebitCardHandlerTest {
    @Mock
    private DebitCardRepository debitCardRepository;
    @InjectMocks
    private DebitCardHandler debitCardHandler;

    @Test
    public void testActiveCard() {
        DebitCard dummyDebitCard = new DebitCard();
        dummyDebitCard.setCardHolder("Dummy User");
        dummyDebitCard.setStatus("ACTIVE");
        List<DebitCard> debitcardList = new ArrayList<>();
        debitcardList.add(dummyDebitCard);
        when(debitCardRepository.findAll()).thenReturn(debitcardList);

        List<DebitCard> list = debitCardHandler.filter4User("Dummy User");
        assertEquals(1, list.size());
    }

    @Test
    public void testNonActiveCard() {
        DebitCard dummyDebitCard = new DebitCard();
        dummyDebitCard.setCardHolder("Dummy User");
        dummyDebitCard.setStatus("BLOCKED");
        List<DebitCard> debitcardList = new ArrayList<>();
        debitcardList.add(dummyDebitCard);
        when(debitCardRepository.findAll()).thenReturn(debitcardList);

        List<DebitCard> list = debitCardHandler.filter4User("Dummy User");
        assertEquals(0, list.size());
    }
}