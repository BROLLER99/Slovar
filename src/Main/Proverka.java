package Main;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Proverka {
    public String proverka_word() {
        String a;
        while (true) {
            System.out.println("Ключ слово: ");
            //Console console = System.console();
            Scanner scan_key = new Scanner(System.in, StandardCharsets.UTF_8);
            //a = console.readLine();
            a = scan_key.nextLine();

            if (Pattern.matches("[a-zA-Z]{4}", a)) {
                break;
            } else {
                System.out.println("Недопустимое слово.");
                System.out.println("Длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки");
            }
        }
        return a;
    }
    public String proverka_number() {
        String a;
        while (true) {
            System.out.println("Ключ слово: ");
            Scanner scan_key = new Scanner(System.in, StandardCharsets.UTF_8);
            a = scan_key.nextLine();

            if (Pattern.matches("[0-9]{5}", a)) {
                break;
            } else {
                System.out.println("Недопустимое слово.");
                System.out.println("Длинна слов может быть только 5 символа и эти символы только цифры.");
            }
        }
        return a;
    }
}
