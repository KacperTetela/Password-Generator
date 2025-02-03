package passwordgenerator.com.password.generator;

import passwordgenerator.com.common.words.APIWordDownloader;
import passwordgenerator.com.common.words.WordAPIParams;
import passwordgenerator.com.password.PasswordCriteria;

public class SoundsLikePasswordGenerator implements PasswordGenerator {

    private static final String relatedWord = "jirraf";

    @Override
    public String generatePassword(PasswordCriteria passwordCriteria) {
        StringBuilder passwordToReturn = new StringBuilder();
        int length = passwordCriteria.digits() ? passwordCriteria.length() - 1 : passwordCriteria.length();
        length = passwordCriteria.special() ? length - 1 : length;

        try {
            passwordToReturn.append(new APIWordDownloader().getFromAPI(new WordAPIParams.Builder()
                    .soundsLike(passwordCriteria.relatedWord())
                    .length(length)
                    .build()));

        } catch (Exception e) {
            passwordToReturn.append(relatedWord);
        }

        return enhancePassword(passwordToReturn, passwordCriteria);
    }

}
