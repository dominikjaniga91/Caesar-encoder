package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Decryptor decryptor = new Decryptor();
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input, output;
        do {
            input = askUserForOperation(in);
            if (input.equals("encrypt")) {
                input = readPlainTextMessageToEncrypt(in);
                output = encryptMessage(input);
                printEncryptedMessage(output);
                break;
            } else if (input.equals("decrypt")) {
                decryptor.decrypt();
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

    private static String readPlainTextMessageToEncrypt(Scanner in) {
        System.out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }

    private static void printEncryptedMessage(String output) {
        System.out.println("Encrypted message: ");
        System.out.println(output);
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
}

