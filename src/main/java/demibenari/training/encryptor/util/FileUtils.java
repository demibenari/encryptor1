package demibenari.training.encryptor.util;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    /**
     * Getting the Whole file content as a single String
     *
     * @param fileToScan File to read from
     * @return String representation of the File input
     */
    public static String getFileContent(File fileToScan) {

        StringBuilder builder = new StringBuilder();

        if (fileToScan.exists()) {
            try {
                Scanner scanner = new Scanner(fileToScan);

                // The delimiter '\\Z' makes the scanner read the whole content of the file with one 'next()' call
                scanner.useDelimiter("\\Z");

                while (scanner.hasNextLine()) {
                    String nextLine = scanner.next();

                    Utils.printOut("Line Read: " + nextLine);

                    builder.append(nextLine);
                }

                scanner.close();  // It's important to Close the scanner in the end of it's use,
                // but notice that you don't close the scanner of (System.in).
                // In case you are reading form the console
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            Utils.printOut("The wanted file was not found: " + fileToScan);
        }

        return builder.toString();
    }

    public static File inputFilePathFromUser() {
        return inputFilePathFromUser("Please enter the wanted file name");
    }

    public static File inputKeyPathFromUser() {
        return inputFilePathFromUser("Please enter the wanted key file name");
    }

    public static File inputFilePathFromUser(String message) {
        Utils.printOut(message);
        String inputFileName = UserInputHandler.inputString();

        File inputFile = new File(inputFileName);

        while (!inputFile.exists()) {
            Utils.printOut("The file: " + inputFile + " doesn't exist");
            Utils.printOut(message + " again");

            inputFileName = UserInputHandler.inputString();
            inputFile = new File(inputFileName);
        }

        return inputFile;
    }

    public static int getKeyFromFile(File keyPath) {
        String keyString = FileUtils.getFileContent(keyPath);
        int key = Integer.valueOf(keyString);
        Utils.printOut("Read Key: " + key);

        return key;
    }

    public static void saveContentToFile(File outputFile, String content) {
        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile));
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            Utils.printOut("There was a problem saving the file under " + outputFile);
            Utils.printOut(ex.getLocalizedMessage());
        }
    }

    public static void writeContentToFile(String outputFilePath, String content) {
        File outputFile = new File(outputFilePath);

        if (outputFile.exists()) {
            outputFile.delete();
        }

        FileUtils.saveContentToFile(outputFile, content);
    }
}
