package passwordgenerator.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorServiceTest {

    private PasswordGeneratorService passwordGeneratorService;

    @BeforeEach
    void setUp() {
        passwordGeneratorService = new PasswordGeneratorService();
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 15, 30})
    public void checkLengthPositive(int passwordLength) {
        String password = passwordGeneratorService.createPassword(PasswordCriteria
                .builder()
                .length(passwordLength)
                .build());

        assertEquals(passwordLength, password.length());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 31, -3, Integer.MAX_VALUE})
    public void checkLengthNegative(int passwordLength) {
        assertThrows(IllegalArgumentException.class, () -> passwordGeneratorService.createPassword(PasswordCriteria
                .builder()
                .length(passwordLength)
                .build()));
    }

/*    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 31, -3, Integer.MAX_VALUE})
    public void checkIsTheSpecialSignRequiredPositive(int valueOfSpecialSigns) {
        String password = passwordGeneratorService.createPassword(PasswordCriteria.builder()
                .special(valueOfSpecialSigns)
                .build());

        Set<Character> specialChars = Set.of(
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '-', '=',
                '[', ']', '{', '}', ';', '\'', ':', '"', '\\', '|', ',', '.', '<', '>', '/', '?'
        );

        long count = password.chars()
                .filter(c -> specialChars.contains((char) c))
                .count();

        System.out.println("count "+count);
        System.out.println("Value of Special Signs "+ valueOfSpecialSigns);

        assertEquals(valueOfSpecialSigns, count);
    }*/

/*    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 31, -3, Integer.MAX_VALUE})
    public void checkIsTheSpecialSignRequiredNegative(int passwordLength) {
        assertThrows(IllegalArgumentException.class, () -> passwordGeneratorService.createPassword(passwordLength));
    }*/
}