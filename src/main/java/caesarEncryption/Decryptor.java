package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Decryptor implements AbstractCoder {
    Scanner in = new Scanner(System.in);

    public void performAction(Scanner in) {
        String input = readPlainTextMessageToDecrypt(in);
        String output = decryptMessage(input);
        printDecryptedMessage(output);
    }

    private String decryptMessage(String input) {
        return input.chars()
                .map(c -> decryptLetter((char) c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private char decryptLetter(char letter) {
        char character;
        if ('A' <= letter && letter <= 'Z') {
            character = shiftLeft(letter);
        } else {
            character = letter;
        }
        return character;
    }

    private char shiftLeft(char letter) {
        char character;
        if (letter - 3 >= 'A') {
            character = (char)(letter - 3);
        } else {
            character = (char)(letter - 3 + 26);
        }
        return character;
    }

    private String readPlainTextMessageToDecrypt(Scanner in) {
        System.out.println("Enter a message to decrypt: ");
        return  in.nextLine();
    }

    private void printDecryptedMessage(String output) {
        System.out.println("Decrypted message: ");
        System.out.println(output);
    }
}
