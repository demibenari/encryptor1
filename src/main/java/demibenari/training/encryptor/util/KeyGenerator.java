package demibenari.training.encryptor.util;

import java.util.Random;

public class KeyGenerator {
    private static final Random RAND = new Random();

    public static int generateKey() {
        int key = Math.abs(RAND.nextInt(256));

        Utils.printOut("Generated Key is: " + key);

        return key;
    }
}
