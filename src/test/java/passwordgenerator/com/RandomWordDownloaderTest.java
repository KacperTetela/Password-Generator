package passwordgenerator.com;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomWordDownloaderTest {

    @Test
    void getRandomWord() {
        RandomWordDownloader randomWordDownloader = new RandomWordDownloader();

        String firstWord = randomWordDownloader.getWord();
        String secondWord = randomWordDownloader.getWord();

        assertNotEquals(firstWord, secondWord);
        assertNotEquals("", firstWord);
        assertNotEquals("", secondWord);

        isStringOnlyWithLetters(firstWord);
        isStringOnlyWithLetters(secondWord);

    }

    private void isStringOnlyWithLetters(String secondWord) {
        for (char symbol : secondWord.toCharArray()) {
            assertTrue(Character.isAlphabetic(symbol));
        }
    }

    @Test
    void getWordStartingWith() {

    }


}