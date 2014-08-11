package demibenari.training.encryptor;

import demibenari.training.encryptor.util.FileUtils;
import demibenari.training.encryptor.util.KeyGenerator;
import demibenari.training.encryptor.util.Utils;

import java.io.File;

/**
 * @author  Demi Ben-Ari
 */

public class FileEncryptor {
    public void encryptFile(File inputFile) {
        int key = KeyGenerator.generateKey();

        String content = FileUtils.getFileContent(inputFile);

        EncryptionAlgorithm m_algo = new EncryptionAlgorithm(content, key);

        String encryptedContent = m_algo.encrypt();

        Utils.printOut(encryptedContent);

        String encryptedFilePath = Utils.generateEncryptedFilePath(inputFile);

        FileUtils.writeContentToFile(encryptedFilePath, encryptedContent);

        String keyPath = Utils.generateKeyPath(inputFile);

        FileUtils.writeContentToFile(keyPath, String.valueOf(key));

        Utils.printOut("The Key file was saved to: " + key);
    }

    public void decryptFile(File encryptedFile, File keyFile) {
        int key = FileUtils.getKeyFromFile(keyFile);

        String content = FileUtils.getFileContent(encryptedFile);

        Utils.printOut("Encrypted: " + content);

        EncryptionAlgorithm m_algo = new EncryptionAlgorithm(content, key);

        String decryptedContent = m_algo.decrypt();

        Utils.printOut("Decrypted: " + decryptedContent);

        String decryptedFilePath = Utils.generateDecryptedFilePath(encryptedFile);
        FileUtils.writeContentToFile(decryptedFilePath,decryptedContent );

        Utils.printOut("The Decrypted File was saved to: " + decryptedFilePath);
    }

}
