package passwordgenerator.com;

public interface PasswordGenerator {
    String generatePassword(int length, int uppercase, int digits, int special);
}
