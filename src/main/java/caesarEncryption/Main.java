package caesarEncryption;

import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input, output;
        do {
            // print a question to user
            System.out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
            if (input.equals("encrypt")) {
                // ask user for text plain message to encrypt
                input = readPlainTextMessageToEncrypt(in);
                output = encryptMessage(input);
                // print encrypted message
                printEncryptedMessage(output);
                break;
            } else if (input.equals("decrypt")) {
                // ask user for text plain message to decrypt
                input = readPlainTextMessageToDecrypt(in);
                output = decryptMessage(input);
                // print decrypted message
                printDecryptedMessage(output);
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
        System.out.println("Vale!");
    }

    private static void printDecryptedMessage(String output) {
        System.out.println("Decrypted message: ");
        System.out.println(output);
    }

    private static void printEncryptedMessage(String output) {
        System.out.println("Encrypted message: ");
        System.out.println(output);
    }

    private static String decryptMessage(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            // decrypt a single letter
            if ('A' <= letter && letter <= 'Z') {
                if (letter - 3 >= 'A') {
                    output.append((char)(letter - 3));
                } else {
                    output.append((char)(letter - 3 + 26));
                }
            } else {
                output.append(letter);
            }
        }
        return output.toString();
    }

    private static String encryptMessage(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            // encrypt a single letter
            if ('A' <= letter && letter <= 'Z') {
                if (letter + 3 <= 'Z') {
                    output.append((char)(letter + 3));
                } else {
                    output.append((char)(letter + 3 - 26));
                }
            } else {
                output.append(letter);
            }
        }
        return output.toString();
    }

    private static String readPlainTextMessageToDecrypt(Scanner in) {
        System.out.println("Enter a message to decrypt: ");
        return  in.nextLine();
    }

    private static String readPlainTextMessageToEncrypt(Scanner in) {
        System.out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }
}

