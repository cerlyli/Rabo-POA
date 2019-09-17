package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.Poa;
import nl.rabobank.powerofattorney.api.products.repositories.PoaRepository;
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
public class PoaHandlerTest {
    @Mock
    private PoaRepository poaRepository;
    @InjectMocks
    private PoaHandler poaHandler;

    @Test
    public void testAll() {
        Poa dummyPoa1 = new Poa();
        Poa dummyPoa2 = new Poa();
        dummyPoa1.setGrantee("Dummy User");
        dummyPoa1.setGrantor("Dummy User2");
        dummyPoa2.setGrantee("Dummy User2");
        dummyPoa2.setGrantor("Dummy User");
        List<Poa> poaList = new ArrayList<>();
        poaList.add(dummyPoa1);
        poaList.add(dummyPoa2);
        when(poaRepository.findAll()).thenReturn(poaList);

        List<Poa> list = poaHandler.filter4User("Dummy User");
        assertEquals(2, list.size());
    }

}