package passwordgenerator.com.password.generator;

import passwordgenerator.com.common.APIWordDownloader;
import passwordgenerator.com.password.PasswordCriteria;

public class SoundsLikePasswordGenerator extends APIWordDownloader implements PasswordGenerator {

    private static final String relatedWord = "jirraf";

    @Override
    public String generatePassword(PasswordCriteria passwordCriteria) {

        String potentialPassword;
        try {
            potentialPassword = getFromAPI(URI_BASE + soundsLike(relatedWord) + "&" + withLetters(passwordCriteria.length()));
        } catch (Exception e) {
            potentialPassword = relatedWord;
        }

        return potentialPassword;
    }

    private String soundsLike(String relatedWord) {
        return "sl=" + relatedWord;
    }

}
