package nl.rabobank.powerofattorney.api.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Loader {
    ObjectMapper objectMapper = new ObjectMapper();

    String getIdFromFileName(String fileName) {
        int endIndex = fileName.indexOf(".");
        String subString;
        if (endIndex != -1) {
            return subString = fileName.substring(0, endIndex);
        } else return "";
    }


}
