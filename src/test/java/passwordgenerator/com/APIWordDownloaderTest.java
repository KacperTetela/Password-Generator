package passwordgenerator.com;

import org.junit.jupiter.api.Test;
import passwordgenerator.com.common.words.APIWordDownloader;

import static org.junit.jupiter.api.Assertions.*;

class APIWordDownloaderTest {

/*    @Test
    void getRandomWord() {
        APIWordDownloader apiWordDownloader = new APIWordDownloader();

        String firstWord = apiWordDownloader.ge
        String secondWord = AutoWordDownloader.getWord();

        assertNotEquals(firstWord, secondWord);
        assertNotEquals("", firstWord);
        assertNotEquals("", secondWord);

        isStringOnlyWithLetters(firstWord);
        isStringOnlyWithLetters(secondWord);

    }*/

    private void isStringOnlyWithLetters(String secondWord) {
        for (char symbol : secondWord.toCharArray()) {
            assertTrue(Character.isAlphabetic(symbol));
        }
    }

    @Test
    void getWordStartingWith() {

    }


}