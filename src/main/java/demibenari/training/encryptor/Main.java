package demibenari.training.encryptor;

import demibenari.training.encryptor.util.FileUtils;
import demibenari.training.encryptor.util.UserInputHandler;
import demibenari.training.encryptor.util.Utils;

import java.io.File;

/**
 * @author  Demi Ben-Ari
 */

public class Main {
    private static final int EXIT = 0;
	private static final int ENCRYPT_OPTION =1;
	private static final int DECRYPT_OPTION = 2;

    public static void main(String[] args) {
        int usersChoice;

        // While the user has not chosen
        do {
            printMenu();
            usersChoice = UserInputHandler.inputInteger();

            switch (usersChoice) {
                case (ENCRYPT_OPTION): {
                    File fileName = FileUtils.inputFilePathFromUser();

                    FileEncryptor encryptor = new FileEncryptor();
                    encryptor.encryptFile(fileName);

                    break;
                }
                case (DECRYPT_OPTION): {
                    File fileName = FileUtils.inputFilePathFromUser();

                    File keyFile = FileUtils.inputKeyPathFromUser();

                    FileEncryptor encryptor = new FileEncryptor();
                    encryptor.decryptFile(fileName, keyFile);

                    break;
                }
                case (EXIT) : {
                    Utils.printOut("You Chose to Exit. Good Buy");
                    break;
                }
                default: {
                    Utils.printOut("This option does not exist. Please choose " + ENCRYPT_OPTION + " for encryption or " + DECRYPT_OPTION + " for decryption.");
                    Utils.printOut("Or " + EXIT + " for Exiting");
                    break;
                }
            }
        } while (usersChoice != EXIT);
	}

	private static void printMenu() {
        Utils.printOut("Hello, Please choose one of the following options:");
        Utils.printOut("--------------------------------------------------");
        Utils.printOut(ENCRYPT_OPTION + ": Encryption");
        Utils.printOut(DECRYPT_OPTION + ": Decryption");
        Utils.printOut(EXIT + ": Exit application");
	}
}
