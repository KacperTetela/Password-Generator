package passwordgenerator.com;

import java.util.ArrayList;
import java.util.List;

public class ComplexPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword(int length, boolean uppercase, boolean digits, boolean special) {
        List<Character> lowerCaseString = new ArrayList<>(PasswordCriteria.LOWER_CASE_STRING);
        List<Character> upperCaseString = new ArrayList<>(PasswordCriteria.UPPER_CASE_STRING);
        List<Character> digitsList = new ArrayList<>(PasswordCriteria.DIGITS);
        List<Character> specialList = new ArrayList<>(PasswordCriteria.SPECIAL_SIGNS);


        {
            int leftSigns = 10;

            int lowerCaseSigns = leftSigns - ((int) ((double) leftSigns * 0.6));
            leftSigns -= lowerCaseSigns;

            int upperCaseSigns = 0;
            int digitsSigns = 0;
            int specialSigns = 0;

            for (int i = 0; i < leftSigns; i++) {
                if (uppercase && leftSigns > 0) {
                    upperCaseSigns++;
                    leftSigns--;
                }

                if (digits && leftSigns > 0) {
                    digitsSigns++;
                    leftSigns--;
                }

                if (special && leftSigns > 0) {
                    specialSigns++;
                    leftSigns--;
                }
            }

        }


        return "";
    }

}
