package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    Scanner in = new Scanner(System.in);
    Decryptor decryptor = new Decryptor();
    Encryptor encryptor = new Encryptor();

    public static void main(String[] args) {

        System.out.println("Ave Caesar! Morituri te salutant!");
        new Caesar().readAction();
        System.out.println("Vale!");
    }

    private void readAction() {
        String input;
        do {
            input = askUserForOperation(in);
            if (input.equals("encrypt")) {
                encryptor.performAction();
                break;
            } else if (input.equals("decrypt")) {
                decryptor.performAction();
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
    }

    private static String askUserForOperation(Scanner in) {
        System.out.println("Would you like to encrypt or decrypt a message?");
        return in.nextLine();
    }


}

