package dictionary;

import dictionary.workConsole.Start;

/**
 * Точка входа в программу
 */
public class Main {
    /**
     * Переменная для указания наличия аргументов командной строки
     */
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

        Start start = new Start();
        start.chooseDictionary();
        start.chooseAction();
    }
}