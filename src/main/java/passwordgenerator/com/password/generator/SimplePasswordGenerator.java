package passwordgenerator.com.password.generator;

import org.springframework.stereotype.Service;
import passwordgenerator.com.common.Utils;
import passwordgenerator.com.common.words.APIWordDownloader;
import passwordgenerator.com.password.PasswordCriteria;

@Service
public class SimplePasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword(PasswordCriteria passwordCriteria) {
        StringBuilder passwordToReturn = new StringBuilder();
        int length = passwordCriteria.digits() ? passwordCriteria.length() - 1 : passwordCriteria.length();
        length = passwordCriteria.special() ? length - 1 : length;

        passwordToReturn.append(new APIWordDownloader().getRandomWord(length));

        //replace first letter to uppercase
        if (passwordCriteria.uppercase()) {
            passwordToReturn = passwordToReturn.replace(0, 1, passwordToReturn.substring(0, 1).toUpperCase());
        }

        //add digit
        if (passwordCriteria.digits()) {
            //passwordToReturn.deleteCharAt(passwordToReturn.length() - 1);
            passwordToReturn.append(PasswordCriteria.DIGITS.get(Utils.getRandomIndex(10)));
        }

        //add special sign
        if (passwordCriteria.special()) {
            passwordToReturn.append(PasswordCriteria.SPECIAL_SIGNS.get(Utils.getRandomIndex(PasswordCriteria.SPECIAL_SIGNS.size())));
        }

        // Password should contain _ instead of spaces
        return passwordToReturn.toString()
                .replace(" ", "_");
    }

}
