package programm;

import java.io.Console;
import java.util.Scanner;

public class Check {

    public String checkConsole() {
        Console console = System.console();
        String cons;
        if (console == null) {
            Scanner scan_value = new Scanner(System.in);
            cons = scan_value.nextLine();
        } else {
            cons = console.readLine();
        }
        return cons;
    }

    public String checkDictionary(int num, String pat) {
        String word;
        while (true) {
            System.out.println("Ключ слово: ");
            word = checkConsole();
            System.out.println();
            if (num == 1 && word.matches(pat)) {
                break;
            } else if (num == 2 && word.matches(pat)) {
                break;
            } else {
                System.out.println("Недопустимое слово.");
            }
        }
        return word;
    }
}
