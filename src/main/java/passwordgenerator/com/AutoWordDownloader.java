package passwordgenerator.com;

import org.springframework.stereotype.Component;

@Component
public class AutoWordDownloader extends APIWordDownloader {

    private String lastWord = "";

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
}
