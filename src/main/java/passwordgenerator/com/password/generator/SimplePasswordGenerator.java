package passwordgenerator.com.password.generator;

import org.springframework.stereotype.Service;
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

        return enhancePassword(passwordToReturn, passwordCriteria);
    }

}
