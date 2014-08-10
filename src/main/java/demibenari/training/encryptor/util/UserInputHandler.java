package demibenari.training.encryptor.util;

import java.util.Scanner;

public class UserInputHandler {
    private final static Scanner reader = new Scanner(System.in);
    public static int inputInteger() {
        int userInt = reader.nextInt();

        return userInt;
    }

    public static String inputString() {
        String userString = reader.next();

        return userString;
    }
}
