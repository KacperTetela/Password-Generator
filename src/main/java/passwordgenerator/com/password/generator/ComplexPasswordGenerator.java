package passwordgenerator.com.password.generator;

import passwordgenerator.com.password.PasswordCriteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static passwordgenerator.com.common.Utils.getRandomIndex;

public class ComplexPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword(PasswordCriteria passwordCriteria) {
        List<Character> lowerCaseString = new ArrayList<>(PasswordCriteria.LOWER_CASE_STRING);
        List<Character> upperCaseString = new ArrayList<>(PasswordCriteria.UPPER_CASE_STRING);
        List<Character> digitsList = new ArrayList<>(PasswordCriteria.DIGITS);
        List<Character> specialList = new ArrayList<>(PasswordCriteria.SPECIAL_SIGNS);

        Collections.shuffle(lowerCaseString);
        Collections.shuffle(upperCaseString);
        Collections.shuffle(digitsList);
        Collections.shuffle(specialList);


        int leftSigns = passwordCriteria.length();
        int lowerCaseSigns = leftSigns - ((int) ((double) leftSigns * 0.6));
        leftSigns -= lowerCaseSigns;

        int upperCaseSigns = 0;
        int digitsSigns = 0;
        int specialSigns = 0;

        int activeCategories = 0;
        if (passwordCriteria.uppercase()) activeCategories++;
        if (passwordCriteria.digits()) activeCategories++;
        if (passwordCriteria.special()) activeCategories++;

        while (leftSigns > 0) {
            if (passwordCriteria.uppercase() && activeCategories > 0) {
                upperCaseSigns++;
                leftSigns--;
            }
            if (passwordCriteria.digits() && activeCategories > 0 && leftSigns > 0) {
                digitsSigns++;
                leftSigns--;
            }
            if (passwordCriteria.special() && activeCategories > 0 && leftSigns > 0) {
                specialSigns++;
                leftSigns--;
            }
        }

        StringBuilder finalPassword = new StringBuilder();
        while (lowerCaseSigns > 0) {
            finalPassword.append(lowerCaseString.get(getRandomIndex(lowerCaseString.size())));
            Collections.shuffle(lowerCaseString);
            lowerCaseSigns--;
        }

        while (upperCaseSigns > 0) {
            finalPassword.append(upperCaseString.get(getRandomIndex(upperCaseString.size())));
            Collections.shuffle(upperCaseString);
            upperCaseSigns--;
        }

        while (digitsSigns > 0) {
            finalPassword.append(digitsList.get(getRandomIndex(digitsList.size())));
            Collections.shuffle(digitsList);
            digitsSigns--;
        }

        while (specialSigns > 0) {
            finalPassword.append(specialList.get(getRandomIndex(specialList.size())));
            Collections.shuffle(specialList);
            specialSigns--;
        }

        return stringShuffle(finalPassword.toString());
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
