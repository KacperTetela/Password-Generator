package passwordgenerator.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComplexPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword(int length, boolean uppercase, boolean digits, boolean special) {
        List<Character> lowerCaseString = new ArrayList<>(PasswordCriteria.LOWER_CASE_STRING);
        List<Character> upperCaseString = new ArrayList<>(PasswordCriteria.UPPER_CASE_STRING);
        List<Character> digitsList = new ArrayList<>(PasswordCriteria.DIGITS);
        List<Character> specialList = new ArrayList<>(PasswordCriteria.SPECIAL_SIGNS);

        Collections.shuffle(lowerCaseString);
        Collections.shuffle(upperCaseString);
        Collections.shuffle(digitsList);
        Collections.shuffle(specialList);


        int leftSigns = length;
        int lowerCaseSigns = leftSigns - ((int) ((double) leftSigns * 0.6));
        leftSigns -= lowerCaseSigns;

        int upperCaseSigns = 0;
        int digitsSigns = 0;
        int specialSigns = 0;

        while (leftSigns > 0) {
            if (uppercase) {
                upperCaseSigns++;
            } else if (digits) {
                digitsSigns++;
            } else if (special) {
                specialSigns++;
            }
            leftSigns--;
        }

        StringBuilder finalPassword = new StringBuilder();
        while (lowerCaseSigns > 0) {
            finalPassword.append(lowerCaseString.get(getRandomIndex(lowerCaseString.size())));
            if (lowerCaseString.size() > 0)
                lowerCaseString.remove(getRandomIndex(lowerCaseString.size()));
            Collections.shuffle(lowerCaseString);
            lowerCaseSigns--;
        }

        while (upperCaseSigns > 0) {
            finalPassword.append(upperCaseString.get(getRandomIndex(upperCaseString.size())));
            if (upperCaseString.size() > 0)
                upperCaseString.remove(getRandomIndex(upperCaseString.size()));
            Collections.shuffle(upperCaseString);
            upperCaseSigns--;
        }

        while (digitsSigns > 0) {
            finalPassword.append(digitsList.get(getRandomIndex(digitsList.size())));
            if (digitsList.size() > 0)
                digitsList.remove(getRandomIndex(digitsList.size()));
            Collections.shuffle(digitsList);
            digitsSigns--;
        }

        while (specialSigns > 0) {
            finalPassword.append(specialList.get(getRandomIndex(specialList.size())));
            if (specialList.size() > 0)
                specialList.remove(getRandomIndex(specialList.size()));
            Collections.shuffle(specialList);
            specialSigns--;
        }

        return stringShuffle(finalPassword.toString());
    }

    private int getRandomIndex(int size) {
        if (size == 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        return (int) (Math.random() * size);
    }

    private String stringShuffle(String toShuffle) {
        // Converting StringBuilder to character list
        List<Character> charList = new ArrayList<>();
        toShuffle.chars().forEach(c -> charList.add((char) c));

        // Character shuffle
        Collections.shuffle(charList);

        // Creating a new StringBuilder from shuffled characters
        StringBuilder shuffledSb = new StringBuilder();
        charList.forEach(shuffledSb::append);

        return shuffledSb.toString();
    }

}
