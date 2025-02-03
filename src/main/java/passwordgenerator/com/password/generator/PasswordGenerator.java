package passwordgenerator.com.password.generator;

import passwordgenerator.com.common.Utils;
import passwordgenerator.com.password.PasswordCriteria;


public interface PasswordGenerator {

    String generatePassword(PasswordCriteria passwordCriteria);

    default String enhancePassword(StringBuilder passwordToEnhance, PasswordCriteria criteria) {
        //replace first letter to uppercase
        if (criteria.uppercase()) {
            passwordToEnhance.replace(0, 1, passwordToEnhance.substring(0, 1).toUpperCase());
        }

        //add digit
        if (criteria.digits()) {
            passwordToEnhance.append(PasswordCriteria.DIGITS.get(Utils.getRandomIndex(10)));
        }

        //add special sign
        if (criteria.special()) {
            passwordToEnhance.append(PasswordCriteria.SPECIAL_SIGNS.get(Utils.getRandomIndex(PasswordCriteria.SPECIAL_SIGNS.size())));
        }

        // Password should contain _ instead of spaces
        return passwordToEnhance.toString()
                .replace(" ", "_");
    }

}
