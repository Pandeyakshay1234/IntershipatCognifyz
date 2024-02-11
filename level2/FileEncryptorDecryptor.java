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

        byte key = 10; // Change this to a different value for more variation

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
























// // import java.io.*;

// // public class FileEncryptorDecryptor {
// //     public static void main(String[] args) {
// //         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
// //             // Prompt user for operation choice
// //             System.out.println("Choose operation:");
// //             System.out.println("1. Encrypt");
// //             System.out.println("2. Decrypt");
// //             int choice = Integer.parseInt(reader.readLine());

// //             // Prompt user for file name or path
// //             System.out.println("Enter file name or path:");
// //             String fileName = reader.readLine();

// //             // Perform chosen operation
// //             if (choice == 1) {
// //                 encryptDecryptFile(fileName, true);
// //             } else if (choice == 2) {
// //                 encryptDecryptFile(fileName, false);
// //             } else {
// //                 System.out.println("Invalid choice.");
// //             }
// //         } catch (IOException e) {
// //             System.err.println("Error reading input: " + e.getMessage());
// //         }
// //     }

// //     // Encryption/Decryption method using Caesar cipher with shift of 3
// //     private static void encryptDecryptFile(String fileName, boolean encrypt) {
// //         try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
// //              BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

// //             int charValue;
// //             while ((charValue = fileReader.read()) != -1) {
// //                 if (Character.isLetter(charValue)) {
// //                     if (encrypt)
// //                         charValue = (charValue + 3 - 'a') % 26 + 'a'; // Encrypt: Shift each letter by 3 positions
// //                     else
// //                         charValue = (charValue - 3 - 'a' + 26) % 26 + 'a'; // Decrypt: Shift each letter back by 3 positions
// //                 }
// //                 fileWriter.write(charValue);
// //             }

// //             System.out.println("File " + (encrypt ? "encrypted" : "decrypted") + " successfully. Output saved as output.txt");
// //         } catch (IOException e) {
// //             System.err.println("Error encrypting/decrypting file: " + e.getMessage());
// //         }
// //     }
// // }



























// // // import java.io.*;

// // // public class FileEncryptorDecryptor {
// // //     public static void main(String[] args) {
// // //         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
// // //             // Prompt user for operation choice
// // //             System.out.println("Choose operation:");
// // //             System.out.println("1. Encrypt");
// // //             System.out.println("2. Decrypt");
// // //             int choice = Integer.parseInt(reader.readLine());

// // //             // Prompt user for file name or path
// // //             System.out.println("Enter input file name or path:");
// // //             String inputFile = reader.readLine();

// // //             // Prompt user for output file name
// // //             System.out.println("Enter output file name:");
// // //             String outputFile = reader.readLine();
// // //             System.out.println(outputFile);

// // //             // Perform chosen operation
// // //             if (choice == 1) {
// // //                 encryptFile(inputFile, outputFile);
// // //             } else if (choice == 2) {
// // //                 decryptFile(inputFile, outputFile);
// // //             } else {
// // //                 System.out.println("Invalid choice.");
// // //             }
// // //         } catch (IOException e) {
// // //             System.err.println("Error reading input: " + e.getMessage());
// // //         }
// // //     }

// // //     // Encryption method using Caesar cipher with shift of 3
// // //     private static void encryptFile(String inputFile, String outputFile) 
// // //     {
// // //         try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
// // //              BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile))) {

// // //             int charValue;
// // //             while ((charValue = fileReader.read()) != -1) {
// // //                 if (Character.isLetter(charValue)) {
// // //                     charValue = (charValue + 3); // Shift each letter by 3 positions
// // //                 }
// // //               //  System.out.println(fileWriter.write(charValue));
// // //                 fileWriter.write(charValue);
// // //             }

// // //             System.out.println("File encrypted successfully. Encrypted file saved as " + outputFile);
// // //         } catch (IOException e)
// // //         {
// // //             System.err.println("Error encrypting file: " + e.getMessage());
// // //         }
// // //     }

// // //     // Decryption method for Caesar cipher with shift of 3
// // //     private static void decryptFile(String inputFile, String outputFile) 
// // //     {
// // //         try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
// // //              BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile))) {

// // //             int charValue;
// // //             while ((charValue = fileReader.read()) != -1) {
// // //                 if (Character.isLetter(charValue)) {
// // //                     charValue = (charValue - 3); // Shift each letter back by 3 positions
// // //                 }
// // //                 char decryptedChar = (char) charValue; // Convert integer value to character
// // //                 fileWriter.write(decryptedChar);
// // //                 // fileWriter.write(charValue);
// // //             }

// // //             System.out.println("File decrypted successfully. Decrypted file saved as " + outputFile);
// // //         } catch (IOException e) {
// // //             System.err.println("Error decrypting file: " + e.getMessage());
// // //         }
// // //     }
// // // }
