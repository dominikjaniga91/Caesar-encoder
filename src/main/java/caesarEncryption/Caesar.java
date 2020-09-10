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
        Encryptor encryptor = new Encryptor();
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input;
        do {
            input = askUserForOperation(in);
            if (input.equals("encrypt")) {
                encryptor.encrypt();
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


}

