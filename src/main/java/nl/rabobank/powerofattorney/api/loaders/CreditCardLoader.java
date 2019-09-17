package nl.rabobank.powerofattorney.api.loaders;

import nl.rabobank.powerofattorney.api.products.CreditCard;
import nl.rabobank.powerofattorney.api.products.repositories.CreditCardRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditCardLoader extends Loader{
    private static final String path = "src\\main\\resources\\testdata\\__files\\credit-card\\";
    final static Logger logger = Logger.getLogger(CreditCardLoader.class);

    @Autowired
    CreditCardRepository creditCardRepository;


    public void loadJsonFiles() {
        try {
            List<Path> paths = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            for (Path path : paths) {
                byte[] jsonData = Files.readAllBytes(path);

                CreditCard creditCard = objectMapper.readValue(jsonData, CreditCard.class);
                String id = getIdFromFileName(path.getFileName().toString());
                creditCard.setId(id);
                creditCardRepository.save(creditCard);
            }
        } catch (IOException e) {
            logger.error("Exception during file operations:",  e);
        }
    }


}
