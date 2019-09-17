package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.Account;
import nl.rabobank.powerofattorney.api.products.repositories.AccountRepository;
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
public class AccountHandlerTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountHandler accountHandler;

    public void setUp() {
        Account dummyAccount = new Account();
        dummyAccount.setOwner("Dummy User");
        List<Account> accountList = new ArrayList<>();
        accountList.add(dummyAccount);
        when(accountRepository.findAll()).thenReturn(accountList);
    }

    @Test
    public void testMatchUser() {
        setUp();
        List<Account> list = accountHandler.filter4User("Dummy User");
        assertEquals(1, list.size());
    }

    @Test
    public void testNoMatchUser() {
        setUp();
        List<Account> list = accountHandler.filter4User("Real User");
        assertEquals(0, list.size());
    }

    public void setUpEndedCard() {
        Account dummyAccount = new Account();
        dummyAccount.setOwner("Dummy User");
        dummyAccount.setEnded("12-10-2007");
        List<Account> accountList = new ArrayList<>();
        accountList.add(dummyAccount);
        when(accountRepository.findAll()).thenReturn(accountList);
    }

    @Test
    public void testFilterEndDate() {
        setUpEndedCard();
        List<Account> list = accountHandler.filter4User("Dummy User");
        assertEquals(0, list.size());
    }
}