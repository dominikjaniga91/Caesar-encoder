package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input, output;
        do {
            input = askUserForOperation(in);
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

    private static String askUserForOperation(Scanner in) {
        System.out.println("Would you like to encrypt or decrypt a message?");
        return in.nextLine();
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
        return input.chars()
                .map(c -> decryptLetter((char) c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private static char decryptLetter(char letter) {
        char character;
        if ('A' <= letter && letter <= 'Z') {
            character = shiftLeft(letter);
        } else {
            character = letter;
        }
        return character;
    }

    private static char shiftLeft(char letter) {
        char character;
        if (letter - 3 >= 'A') {
            character = (char)(letter - 3);
        } else {
            character = (char)(letter - 3 + 26);
        }
        return character;
    }

    private static String encryptMessage(String input) {
        return input.chars()
                .map(c -> encryptLetter((char) c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private static char encryptLetter(char letter) {
        char character;
        if ('A' <= letter && letter <= 'Z') {
            character = shiftRight(letter);
        } else {
            character = letter;
        }
        return character;
    }

    private static char shiftRight(char letter) {
        char character;
        if (letter + 3 <= 'Z') {
            character = (char)(letter + 3);
        } else {
            character = (char)(letter + 3 - 26);
        }
        return character;
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

