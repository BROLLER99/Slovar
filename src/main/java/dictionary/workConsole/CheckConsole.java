package dictionary.workConsole;

import java.io.Console;
import java.util.Scanner;

/**
 * Класс предназначен для проверки наличия консоли
 */
public class CheckConsole {
    /**
     * Метод проверяет наличие созданной консоли, если её нет то использует Scanner
     */
    public String check() {
        Console console = System.console();
        String inputWord;
        if (console == null) {
            Scanner scan_value = new Scanner(System.in);
            inputWord = scan_value.nextLine();
        } else {
            inputWord = console.readLine();
        }
        return inputWord;
    }
}
