package passwordgenerator.com;

public interface PasswordGenerator {

    String generatePassword(int length, boolean uppercase, boolean digits, boolean special);

}
