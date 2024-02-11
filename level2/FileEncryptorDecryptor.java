import java.io.*;
import java.util.*;

public class FileEncryptorDecryptor {

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'e' to encrypt or 'd' to decrypt: ");
        char choice = scanner.nextLine().toLowerCase().charAt(0);

        System.out.print("Enter the file name (including path): ");
        String filename = scanner.nextLine();

        System.out.print("Enter the output file name (including path): ");
        String outputFilename = scanner.nextLine();

        byte key = 10; 

        switch (choice) {
            case 'e':
                encryptFile(filename, outputFilename, key);
                break;
            case 'd':
                decryptFile(filename, outputFilename, key);
                break;
            default:
                System.out.println("Invalid choice. Please enter 'e' or 'd'.");
        }
    }

    public static void encryptFile(String inputFilename, String outputFilename, byte key) throws IOException {
        try (FileInputStream input = new FileInputStream(inputFilename);
             FileOutputStream output = new FileOutputStream(outputFilename)) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data ^ key);
            }
        }
        System.out.println("File encrypted successfully.");
    }

    public static void decryptFile(String inputFilename, String outputFilename, byte key) throws IOException {
        try (FileInputStream input = new FileInputStream(inputFilename);
             FileOutputStream output = new FileOutputStream(outputFilename)) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data ^ key);
            }
        }
        System.out.println("File decrypted successfully.");
    }
}

