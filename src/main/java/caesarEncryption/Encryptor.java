package caesarEncryption;

import java.util.Scanner;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class Encryptor implements AbstractCoder {

    @Override
    public void performAction(Scanner in) {
        String input = readPlainTextMessageToEncrypt(in);
        String output = encryptMessage(input);
        printEncryptedMessage(output);
    }

    private String readPlainTextMessageToEncrypt(Scanner in) {
        out.println("Enter a message to encrypt: ");
        return in.nextLine();
    }

    private void printEncryptedMessage(String output) {
        out.println("Encrypted message: ");
        out.println(output);
    }

    private String encryptMessage(String input) {
        return input.chars()
                .map(c -> encryptLetter((char) c))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }

    private char encryptLetter(char letter) {
        char character;
        if (isAlphabeticalLetter(letter)) {
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
