package nl.rabobank.powerofattorney.api.handlers;

import nl.rabobank.powerofattorney.api.products.*;
import nl.rabobank.powerofattorney.api.products.repositories.CreditCardRepository;
import nl.rabobank.powerofattorney.api.products.repositories.DebitCardRepository;
import nl.rabobank.powerofattorney.api.products.repositories.PoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PoaHandler {
    @Autowired
    PoaRepository poaRepository;
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    DebitCardRepository debitCardRepository;

    public List<Poa> filter4User(String user) {
        List<Poa> granteeList = getGranteeList(user);

        List<Poa> granteePoaList = poaRepository.findAll().stream()
                .filter(Poa.class::isInstance)
                .map(Poa.class::cast)
                .filter(poa -> poa.getGrantor().equals(user))
                .collect(Collectors.toList());

        return Stream.concat(granteeList.stream(), granteePoaList.stream())
                .collect(Collectors.toList());
    }

    private List<Poa> getGranteeList(String user){
        return poaRepository.findAll().stream()
                .filter(Poa.class::isInstance)
                .map(Poa.class::cast)
                .filter(poa -> poa.getGrantee().equals(user))
                .collect(Collectors.toList());
    }


    public List<CreditCard> findAuthorizedCreditcard4User(String user) {
        List<Poa> granteePoaList = getGranteeList(user);

        List<CreditCard> authorizedCreditCards= new ArrayList<>();
        for (Poa granteePoa:granteePoaList){
            if (granteePoa.getCards() == null)
                continue;
            else{
                List<Card> cardList =  granteePoa.getCards();
                for (Card card: cardList){
                    String id = card.getId();
                    if (card.getType().equals("CREDIT_CARD"))
                        authorizedCreditCards.add(creditCardRepository.find(id));
                }
            }
        }
        return authorizedCreditCards;
    }

    public List<DebitCard> findAuthorizedDebitcard4User(String user) {
        List<Poa> granteePoaList = getGranteeList(user);

        List<DebitCard> authorizedDebitCards= new ArrayList<>();
        for (Poa granteePoa:granteePoaList){
            if (granteePoa.getCards() == null)
                continue;
            else{
                List<Card> cardList =  granteePoa.getCards();
                for (Card card: cardList){
                    String id = card.getId();
                    if (card.getType().equals("DEBIT_CARD"))
                        authorizedDebitCards.add(debitCardRepository.find(id));
                }
            }
        }

        return authorizedDebitCards;
    }

}
