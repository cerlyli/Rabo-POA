package nl.rabobank.powerofattorney.api;

import nl.rabobank.powerofattorney.api.loaders.AccountLoader;
import nl.rabobank.powerofattorney.api.loaders.CreditCardLoader;
import nl.rabobank.powerofattorney.api.loaders.DebitCardLoader;
import nl.rabobank.powerofattorney.api.loaders.PoaLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        AccountLoader accountLoader = (AccountLoader) applicationContext.getBean("accountLoader");
        DebitCardLoader debitCardLoader = (DebitCardLoader) applicationContext.getBean("debitCardLoader");
        PoaLoader poaLoader = (PoaLoader) applicationContext.getBean("poaLoader");
        CreditCardLoader creditCardLoader = (CreditCardLoader) applicationContext.getBean("creditCardLoader");

        accountLoader.loadJsonFiles();
        debitCardLoader.loadJsonFiles();
        poaLoader.loadJsonFiles();
        creditCardLoader.loadJsonFiles();

    }
}
