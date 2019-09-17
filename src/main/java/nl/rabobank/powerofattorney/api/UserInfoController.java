package nl.rabobank.powerofattorney.api;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @Autowired
    JsonAggregator jsonAggregator;


    @GetMapping("/users-info/{name}")
    public JsonNode findUserInfo(@PathVariable String name) {
        return jsonAggregator.getAggregatedJson4User(name);
    }
}
