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
                output = "";
                // encrypt provided message
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    // encrypt a single letter
                    // 'A' <= letter && letter <= 'Z'
                    if ('A' <= letter && letter <= 'Z') {
                        if (letter + 3 <= 'Z') {
                            output = output + (char)(letter + 3);
                        } else {
                            output = output + (char)(letter + 3 - 26);
                        }
                    } else {
                        output = output + letter;
                    }
                }
                // print encrypted message
                System.out.println("Encrypted message: ");
                System.out.println(output);
                break;
            } else if (input.equals("decrypt")) {
                // ask user for text plain message to decrypt
                System.out.println("Enter a message to decrypt: ");
                input = in.nextLine();
                output = "";
                // decrypt provided message
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    // decrypt a single letter
                    if ('A' <= letter && letter <= 'Z') {
                        if (letter - 3 >= 'A') {
                            output = output + (char)(letter - 3);
                        } else {
                            output = output + (char)(letter - 3 + 26);
                        }
                    } else {
                        output = output + letter;
                    }
                }
                // print decrypted message
                System.out.println("Decrypted message: ");
                System.out.println(output);
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
        System.out.println("Vale!");
    }

    private static String readPlainTextMessageToEncrypt(Scanner in) {
        System.out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }
}

