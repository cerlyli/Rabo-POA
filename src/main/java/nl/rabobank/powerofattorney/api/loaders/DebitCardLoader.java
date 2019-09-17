package nl.rabobank.powerofattorney.api.loaders;

import nl.rabobank.powerofattorney.api.products.DebitCard;
import nl.rabobank.powerofattorney.api.products.repositories.DebitCardRepository;
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
public class DebitCardLoader extends Loader {
    private static final String path = "src\\main\\resources\\testdata\\__files\\debit-card\\";
    final static Logger logger = Logger.getLogger(DebitCardLoader.class);

    @Autowired
    DebitCardRepository debitCardRepository;

    public void loadJsonFiles() {
        try {
            List<Path> paths = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            for (Path path : paths) {
                byte[] jsonData = Files.readAllBytes(path);

                DebitCard debitCard = objectMapper.readValue(jsonData, DebitCard.class);
                String id = getIdFromFileName(path.getFileName().toString());
                debitCard.setId(id);
                debitCardRepository.save(debitCard);
            }
        } catch (IOException e) {
            logger.error("Exception during file operations:",  e);
        }
    }


}
