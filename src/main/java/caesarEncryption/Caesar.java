package caesarEncryption;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    private final Scanner in;

    public Caesar(Scanner in) {
        this.in = in;
    }

    private String readAction() {
        String operation;
        while (true) {
            operation = askUserForOperation(in);
            if ("encrypt".equals(operation) || "decrypt".equals(operation)) {
                return operation;
            } else {
                out.println("Tertium non datur!");
            }
        }
    }

    private String askUserForOperation(Scanner in) {
        out.println("Would you like to encrypt or decrypt a message?");
        return in.nextLine();
    }

    private void run() {
        String operation = readAction();
        AbstractCoder coder;
        if ("encrypt".equals(operation)) {
            coder = new Encryptor();
        } else {
            coder = new Decryptor();
        }
        coder.performAction(in);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out.println("Ave Caesar! Morituri te salutant!");
        new Caesar(in).run();
        out.println("Vale!");
    }

}

