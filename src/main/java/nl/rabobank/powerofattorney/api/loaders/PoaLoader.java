package nl.rabobank.powerofattorney.api.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.rabobank.powerofattorney.api.products.Account;
import nl.rabobank.powerofattorney.api.products.Poa;
import nl.rabobank.powerofattorney.api.products.repositories.AccountRepository;
import nl.rabobank.powerofattorney.api.products.repositories.PoaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PoaLoader extends Loader{
    private static final String path = "src\\main\\resources\\testdata\\__files\\poa\\";
    final static Logger logger = Logger.getLogger(PoaLoader.class);

    @Autowired
    private PoaRepository poaRepository;

    public void loadJsonFiles() {
        try {
            List<Path> paths = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .filter(path -> !path.getFileName().endsWith("poa.json"))
                    .collect(Collectors.toList());

            for (Path path : paths) {
                byte[] jsonData = Files.readAllBytes(path);

                Poa poa = objectMapper.readValue(jsonData, Poa.class);
                String id = getIdFromFileName(path.getFileName().toString());
                poa.setId(id);
                poaRepository.save(poa);
            }
        } catch (IOException e) {
            logger.error("Exception during file operations:",  e);
        }
    }
}
