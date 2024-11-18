package passwordgenerator.com;

import org.springframework.stereotype.Service;

@Service
public class PasswordGeneratorService {

    private final PasswordFactory passwordFactory;

    public PasswordGeneratorService(PasswordFactory passwordFactory) {
        this.passwordFactory = passwordFactory;
    }

    public String createPassword(PasswordCriteria passwordCriteria) {


        return "a".repeat(passwordCriteria.length());
    }

}
