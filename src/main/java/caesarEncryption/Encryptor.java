package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Encryptor implements AbstractCoder {

    Scanner in = new Scanner(System.in);

    public void performAction(Scanner in) {
        String input = readPlainTextMessageToEncrypt(in);
        String output = encryptMessage(input);
        printEncryptedMessage(output);
    }

    private String readPlainTextMessageToEncrypt(Scanner in) {
        System.out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }

    private void printEncryptedMessage(String output) {
        System.out.println("Encrypted message: ");
        System.out.println(output);
    }

    private String encryptMessage(String input) {
        return input.chars()
                .map(c -> encryptLetter((char) c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private char encryptLetter(char letter) {
        char character;
        if ('A' <= letter && letter <= 'Z') {
            character = shiftRight(letter);
        } else {
            character = letter;
        }
        return character;
    }

    private char shiftRight(char letter) {
        char character;
        if (letter + 3 <= 'Z') {
            character = (char)(letter + 3);
        } else {
            character = (char)(letter + 3 - 26);
        }
        return character;
    }
}
