package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    Scanner in;

    public Caesar(Scanner in) {
        this.in = in;
    }

    private String readAction() {
        String input;
        while (true) {
            input = askUserForOperation(in);
            if ("encrypt".equals(input) || "decrypt".equals(input)) {
                return input;
            } else {
                System.out.println("Tertium non datur!");
            }
        }
    }

    private void run() {
        String input = readAction();
        AbstractCoder coder;
        if ("encrypt".equals(input)) {
            coder = new Encryptor();
        } else {
            coder = new Decryptor();
        }
        coder.performAction(in);
    }

    private static String askUserForOperation(Scanner in) {
        System.out.println("Would you like to encrypt or decrypt a message?");
        return in.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Ave Caesar! Morituri te salutant!");
        Scanner in = new Scanner(System.in);
        new Caesar(in).run();
        System.out.println("Vale!");
    }

}

