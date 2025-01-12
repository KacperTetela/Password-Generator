package passwordgenerator.com.common.words;

import org.springframework.web.client.RestClient;
import passwordgenerator.com.common.Utils;

public class APIWordDownloader {

    private String lastWord = "";

    public String getRandomWord(int length) {
        if (lastWord.isEmpty()) {
            lastWord = getFromAPI(new WordAPIParams.Builder()
                    .length(length)
                    .build());
        } else {
            lastWord = getFromAPI(new WordAPIParams.Builder()
                    .similarTo(lastWord)
                    .length(length)
                    .build());
        }
        if (lastWord.isEmpty()) {
            lastWord = getRandomWord(length);
        }

        return lastWord;
    }

    public String getFromAPI(WordAPIParams wordAPIParams) {

        RestClient restClient = RestClient.create();

        // Record for mapping JSON response
        record SimpleWordDTO(String word) {
        }

        SimpleWordDTO[] simpleWordDTOS = restClient.get()
                .uri(wordAPIParams.buildURL())
                .retrieve()
                .body(SimpleWordDTO[].class);

        if (simpleWordDTOS.length == 0)
            return "";

        return simpleWordDTOS[Utils.getRandomIndex(simpleWordDTOS.length)].word();
    }

}
