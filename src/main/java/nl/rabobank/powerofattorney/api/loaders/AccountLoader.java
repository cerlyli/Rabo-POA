package nl.rabobank.powerofattorney.api.loaders;

import nl.rabobank.powerofattorney.api.products.Account;
import nl.rabobank.powerofattorney.api.products.repositories.AccountRepository;
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
public class AccountLoader extends Loader {
    private static final String path = "src\\main\\resources\\testdata\\__files\\accounts\\";
    final static Logger logger = Logger.getLogger(AccountLoader.class);

    @Autowired
    private AccountRepository accountRepository;

    public void loadJsonFiles() {
        List<Path> paths = null;
        try {
            paths = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

            for (Path path : paths) {
                byte[] jsonData = Files.readAllBytes(path);

                Account account = objectMapper.readValue(jsonData, Account.class);
                accountRepository.save(account);

            }
        } catch (IOException e) {
            logger.error("Exception during file operations:",  e);
        }

    }

}
