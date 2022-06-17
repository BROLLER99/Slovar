package dictionary;

import dictionary.work.console.View;

/**
 * Точка входа в программу
 */
public class Main {
    public static int argsCommandLine;

    /**
     * Запуск консольного приложения
     *
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            argsCommandLine = 1;
        } else argsCommandLine = 0;

        View view = new View();
        view.chooseDictionary();
        view.chooseAction();
    }
}