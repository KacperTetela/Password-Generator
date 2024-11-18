package passwordgenerator.com;

import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {

    public String createPassword(PasswordCriteria passwordCriteria) {
        StringBuilder password = new StringBuilder();

        String lowercaseString = "";


        return "a".repeat(passwordCriteria.length());
    }

    private String generateLowercaseString() {
        StringBuilder lowercaseString = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            lowercaseString.append(c);
        }
        return lowercaseString.toString();
    }

}
