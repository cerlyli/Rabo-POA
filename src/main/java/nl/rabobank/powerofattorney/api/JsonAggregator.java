package nl.rabobank.powerofattorney.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.rabobank.powerofattorney.api.handlers.AccountHandler;
import nl.rabobank.powerofattorney.api.handlers.CreditCardHandler;
import nl.rabobank.powerofattorney.api.handlers.DebitCardHandler;
import nl.rabobank.powerofattorney.api.handlers.PoaHandler;
import nl.rabobank.powerofattorney.api.products.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonAggregator {
    @Autowired
    AccountHandler accountHandler;
    @Autowired
    DebitCardHandler debitCardHandler;
    @Autowired
    CreditCardHandler creditCardHandler;
    @Autowired
    PoaHandler poaHandler;

    private static ObjectMapper mapper = new ObjectMapper();

    public JsonNode getAggregatedJson4User(String user) {
        List<Account> accounts = accountHandler.filter4User(user);
        List<DebitCard> debitCards = debitCardHandler.filter4User(user);
        List<CreditCard> creditCards = creditCardHandler.filter4User(user);
        //List all POA info for the user
        List<Poa> poas = poaHandler.filter4User(user);

        List<CreditCard> authorizedCreditcard4User = poaHandler.findAuthorizedCreditcard4User(user);
        mergeCreditcardList(creditCards, authorizedCreditcard4User);

        List<DebitCard> authorizedDebitcard4User = poaHandler.findAuthorizedDebitcard4User(user);
        mergeDebitcardList(debitCards, authorizedDebitcard4User);

        JsonNode accountJsonNode = mapper.valueToTree(accounts);
        JsonNode debitCardJsonNode = mapper.valueToTree(debitCards);
        JsonNode creditCardJsonNode = mapper.valueToTree(creditCards);
        JsonNode poaJsonNode = mapper.valueToTree(poas);

        JsonNode rootNode = mapper.createObjectNode();
        ((ObjectNode) rootNode).set("accounts", accountJsonNode);
        ((ObjectNode) rootNode).set("debitCards", debitCardJsonNode);
        ((ObjectNode) rootNode).set("creditCards", creditCardJsonNode);
        ((ObjectNode) rootNode).set("poas", poaJsonNode);

        return rootNode;
    }

    private List mergeCreditcardList(List<CreditCard> cards, List<CreditCard> authorized4User) {
        //Merge duplicated cards
        for (CreditCard card2add : authorized4User) {
            boolean foundDuplication = false;
            for (CreditCard card : cards) {
                if (card2add.getId().equals(card))
                    foundDuplication = true;
            }
            if (!foundDuplication){
                cards.add(card2add);
            }
        }
        return cards;
    }

    private List mergeDebitcardList(List<DebitCard> cards, List<DebitCard> authorized4User) {
        //Merge duplicated cards
        for (DebitCard card2add : authorized4User) {
            boolean foundDuplication = false;
            for (DebitCard card : cards) {
                if (card2add.getId().equals(card))
                    foundDuplication = true;
            }
            if (!foundDuplication){
                cards.add(card2add);
            }
        }
        return cards;
    }
}
