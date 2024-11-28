package passwordgenerator.com;

import java.util.Random;

public class Utils {
    public static int getRandomIndex(int size) {
        return new Random().nextInt(size);
    }

    public static char getRandomASCILetter() {
        return (char) new Random().nextInt(97, 123);
    }
}
