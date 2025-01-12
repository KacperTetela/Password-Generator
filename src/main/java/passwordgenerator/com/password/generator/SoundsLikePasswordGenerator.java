package passwordgenerator.com.password.generator;

import passwordgenerator.com.common.words.APIWordDownloader;
import passwordgenerator.com.common.words.WordAPIParams;
import passwordgenerator.com.password.PasswordCriteria;

public class SoundsLikePasswordGenerator implements PasswordGenerator {

    private static final String relatedWord = "jirraf";

    @Override
    public String generatePassword(PasswordCriteria passwordCriteria) {

        String potentialPassword;
        try {
            potentialPassword = new APIWordDownloader().getFromAPI(new WordAPIParams.Builder()
                    .soundsLike(passwordCriteria.relatedWord())
                    .length(passwordCriteria.length())
                    .build());

        } catch (Exception e) {
            potentialPassword = relatedWord;
        }

        return potentialPassword;
    }

}
