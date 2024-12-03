package passwordgenerator.com;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class APIWordDownloader {

    private static final String URI_BASE = "https://api.datamuse.com/words?";
    private String lastWord = "";

    private String similarTo(String similarWord) {
        return "ml=" + similarWord;
    }

    private String withLetters(int length) {
        return withLetters(length, "");
    }

    private String withLetters(int length, String startingLetter) {
        return "sp=" + (startingLetter.isEmpty() ? "?" : startingLetter) + "?".repeat(length - 1);
    }

    String getRandomWord(int length) {
        if (lastWord.isEmpty()) {
            lastWord = getFromAPI(URI_BASE + withLetters(length, String.valueOf(Utils.getRandomASCILetter())));
        } else {
            lastWord = getFromAPI(URI_BASE + similarTo(lastWord) + "&" + withLetters(length));
        }
        if (lastWord.isEmpty()) {
            lastWord = getRandomWord(length);
        }

        return lastWord;
    }

    private String getFromAPI(String url) {

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

    private String getFirstLetters() {
        char startingValue = Utils.getRandomASCILetter();
        return new StringBuilder()
                .append(startingValue)
                .toString();
    }
}
