package passwordgenerator.com.common;

import org.springframework.web.client.RestClient;

public abstract class APIWordDownloader {

    protected static final String URI_BASE = "https://api.datamuse.com/words?";

    protected String withLetters(int length) {
        return withLetters(length, "");
    }

    protected String withLetters(int length, String startingLetter) {
        return "sp=" + (startingLetter.isEmpty() ? "?" : startingLetter) + "?".repeat(length - 1);
    }

    protected String getFromAPI(String url) {

        RestClient restClient = RestClient.create();

        // Record for mapping JSON response
        record SimpleWordDTO(String word) {
        }

        SimpleWordDTO[] simpleWordDTOS = restClient.get()
                .uri(url)
                .retrieve()
                .body(SimpleWordDTO[].class);

        if (simpleWordDTOS.length == 0)
            return "";

        return simpleWordDTOS[Utils.getRandomIndex(simpleWordDTOS.length)].word();
    }
}
