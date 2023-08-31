import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ItSec2 {

    public static void main(String[] args) {

        String password = "Greg";
        String encryptedPassword = encrypt(password);

        System.out.println("Password = "+ password);
        System.out.println("Encrypted password = " + encryptedPassword);

        double startTime = System.currentTimeMillis();
        System.out.print(decrypter(password, encryptedPassword));
        double endTime = System.currentTimeMillis();

        System.out.println(" in " + ((endTime - startTime)/1000) + " seconds");

    }

    public static String encrypt(String password) {
        List<Character> letters = new ArrayList<>();
        for(char c = 'A'; c <= 'Z'; c++) {
            letters.add(c);
        }
        for(char c = 'a'; c <= 'z'; c++){
            letters.add(c);
        }

        Collections.shuffle(letters, new Random());
        StringBuilder encrypted = new StringBuilder();

        for(char letter : password.toCharArray()) {
            char encryptedLetter = letter;
            if(Character.isLetter(letter)) {
                int index = Character.isUpperCase(letter) ? letter - 'A' : letter - 'a';
                encryptedLetter = letters.get(index);
            }
            encrypted.append(encryptedLetter);
        }
        return encrypted.toString();
    }


    // Add timer for fun
    public static String decrypter(String password, String encryptedPassword) {
        List<Character> letters = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            letters.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            letters.add(c);
        }

        int tries = 0;
        StringBuilder pass = new StringBuilder(encryptedPassword);
        while (!pass.toString().equals(password)) {
            Collections.shuffle(letters, new Random());
            for (int i = 0; i < password.length(); i++) {
                char originalLetter = password.charAt(i);
                int index = Character.isUpperCase(originalLetter) ? originalLetter - 'A' : originalLetter - 'a';
                char encryptedLetter = letters.get(index);
                pass.setCharAt(i, encryptedLetter);
            }
            tries++;
        }

        return "Decryption took " + tries + " solutions";
    }

}