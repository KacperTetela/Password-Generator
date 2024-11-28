package passwordgenerator.com;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RandomWordDownloader {

    private static final String URI_BASE = "https://api.datamuse.com/words?sp=%s*";

    private String getFromAPI() {

        RestClient restClient = RestClient.create();

        SimpleWordDTO[] simpleWordDTOS = restClient.get()
                .uri(String.format(URI_BASE, getTwoFirstLetters()))
                .retrieve()
                .body(SimpleWordDTO[].class);

        if (simpleWordDTOS.length == 0)
            return getFromAPI();

        return simpleWordDTOS[Utils.getRandomIndex(simpleWordDTOS.length)].word();
    }

    private String getTwoFirstLetters() {
        char startingValue = Utils.getRandomASCILetter();
        char endingValue = Utils.getRandomASCILetter();
        return new StringBuilder()
                .append(startingValue)
                .append(endingValue)
                .toString();
    }
}
