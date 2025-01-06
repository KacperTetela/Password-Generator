package passwordgenerator.com.password.generator;

import passwordgenerator.com.password.PasswordCriteria;

public interface PasswordGenerator {

    String generatePassword(PasswordCriteria passwordCriteria);

}
