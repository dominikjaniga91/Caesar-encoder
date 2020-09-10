package caesarEncryption;

import java.util.Scanner;

public interface AbstractCoder {

    void performAction(Scanner in);

    default boolean isAlphabeticalLetter(char letter) {
        return 'A' <= letter && letter <= 'Z';
    }
}