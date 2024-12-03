package passwordgenerator.com;


import org.springframework.stereotype.Service;

@Service
public class SimplePasswordGenerator implements PasswordGenerator {

    private APIWordDownloader apiWordDownloader = new APIWordDownloader();

    @Override
    public String generatePassword(int length, boolean uppercase, boolean digits, boolean special) {
        StringBuilder passwordToReturn = new StringBuilder();
        length = digits ? length - 1 : length;
        length = special ? length - 1 : length;

        passwordToReturn.append(apiWordDownloader.getRandomWord(length));

        //replace first letter to uppercase
        if (uppercase) {
            passwordToReturn = passwordToReturn.replace(0, 1, passwordToReturn.substring(0, 1).toUpperCase());
        }

        //add digit
        if (digits) {
            //passwordToReturn.deleteCharAt(passwordToReturn.length() - 1);
            passwordToReturn.append(PasswordCriteria.DIGITS.get(Utils.getRandomIndex(10)));
        }

        //add special sign
        if (special) {
            passwordToReturn.append(PasswordCriteria.SPECIAL_SIGNS.get(Utils.getRandomIndex(32)));
        }

        // Password should contain _ instead of spaces
        return passwordToReturn.toString()
                .replace(" ", "_");
    }

}
