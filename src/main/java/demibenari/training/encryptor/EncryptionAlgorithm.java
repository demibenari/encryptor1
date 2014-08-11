package demibenari.training.encryptor;

import demibenari.training.encryptor.util.Utils;

/**
 * @author  Demi Ben-Ari
 */

public class EncryptionAlgorithm {
    private String encryptionContent = "";
    private int encryptionKey = 0;

    public EncryptionAlgorithm(String content, int key) {
        encryptionContent = content;
        encryptionKey = key;
    }

    public String encrypt() {
        StringBuilder builder = new StringBuilder();

        // Going over all the charchters in the content, encrypting and appending all of them to the result StringBuilder
        for (int index = 0 ; index < encryptionContent.length() ; index++) {
            char currentChar = encryptionContent.charAt(index);

            builder.append(encryptChar(currentChar, encryptionKey));
        }

        Utils.printOut("Content was encrypted");

        return builder.toString();
    }

    public String decrypt() {
        StringBuilder builder = new StringBuilder();

        // Going over all the charchters in the content, decrypting and appending all of them to the result StringBuilder
        for (int index = 0 ; index < encryptionContent.length() ; index++) {
            char currentChar = encryptionContent.charAt(index);

            builder.append(decryptChar(currentChar, encryptionKey));
        }

        return builder.toString();
    }

    private char encryptChar(char charToEncrypt, int key) {
        return (char) ((charToEncrypt + (char)key) % 255);
    }

    private char decryptChar(char charToDecrypt, int key) {
        return (char) (((charToDecrypt -key) + 255) % 255);
    }
}
