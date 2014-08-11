package demibenari.training.encryptor.util;

import java.util.Scanner;

/**
 * @author  Demi Ben-Ari
 */

public class UserInputHandler {
    private final static Scanner reader = new Scanner(System.in);
    public static int inputInteger() {
        return reader.nextInt();
    }

    public static String inputString() {
        return reader.next();
    }
}
