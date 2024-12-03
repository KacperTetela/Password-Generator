package passwordgenerator.com;

import java.util.Map;

public class PasswordFactory {

    private final Map<PasswordNameStrategy, PasswordGenerator> generators;

    public PasswordFactory(Map<PasswordNameStrategy, PasswordGenerator> generators) {
        this.generators = generators;
    }

    public String createPassword(PasswordNameStrategy strategy, int length, boolean uppercase, boolean digits, boolean special) {
        PasswordGenerator generator = generators.get(strategy);

        if (generator == null) {
            throw new IllegalArgumentException("No generator found for strategy: " + strategy);
        }

        return generator.generatePassword(length, uppercase, digits, special);
    }
}