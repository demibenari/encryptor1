package demibenari.training.encryptor.util;

import java.io.File;

/**
 * @author  Demi Ben-Ari
 */

public class Utils {

    private static final String ENCRYPTED_SUFFIX = "_encrypted";
    private static final String DECRYPTED_SUFFIX = "_decrypted";
    private static final String KEY_FILE_NAME = "key.txt";

    public static void printOut(String message) {
        System.out.println(message);
    }

    public static String generateEncryptedFilePath(File inputFileName) {
        String absoluteFilePath = inputFileName.getAbsolutePath();

        String result = insertEncryptedSuffix(absoluteFilePath);

        Utils.printOut(absoluteFilePath);

        return result;
    }

    public static String generateDecryptedFilePath(File inputFileName) {
        String absoluteFilePath = inputFileName.getAbsolutePath();

        return insertDecryptedSuffix(absoluteFilePath);
    }

    public static String getFileDirectoryPath(File inputFileName) {
        String parent = inputFileName.getParent();

        Utils.printOut(parent);

        return parent;
    }

    private static String insertSuffixToFile(String filePath, String suffix) {
        int lastDotIndex = findLastDotIndex(filePath);

        String result = filePath.substring(0, lastDotIndex) + suffix + filePath.substring(lastDotIndex, filePath.length());

        printOut("File with Suffix: " + result);

        return result;
    }

    private static String insertEncryptedSuffix(String filePath) {
        return insertSuffixToFile(filePath, ENCRYPTED_SUFFIX);
    }

    private static String insertDecryptedSuffix(String filePath) {
        return insertSuffixToFile(filePath, DECRYPTED_SUFFIX);
    }

    private static int findLastDotIndex(String string) {
        return string.lastIndexOf(".");
    }

    public static String generateKeyPath(File file) {
        String parentDirectory = getFileDirectoryPath(file);
        return parentDirectory + File.separator + KEY_FILE_NAME;
    }
}
