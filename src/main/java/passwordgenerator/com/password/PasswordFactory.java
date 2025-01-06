package passwordgenerator.com.password;

import passwordgenerator.com.password.generator.PasswordGenerator;
import passwordgenerator.com.password.generator.PasswordNameStrategy;

import java.util.Map;

public class PasswordFactory {

    private final Map<PasswordNameStrategy, PasswordGenerator> generators;

    public PasswordFactory(Map<PasswordNameStrategy, PasswordGenerator> generators) {
        this.generators = generators;
    }

    public String createPassword(PasswordCriteria passwordCriteria) {
        PasswordGenerator generator = generators.get(passwordCriteria.strategy());

        if (generator == null) {
            throw new IllegalArgumentException("No password found for strategy: " + passwordCriteria.strategy());
        }

        return generator.generatePassword(passwordCriteria);
    }
}