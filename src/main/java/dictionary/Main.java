package dictionary;

import dictionary.work.DAO.Dictionary;
import dictionary.work.DAO.LocalDictionary;
import dictionary.work.DAO.RunTimeDictionary;
import dictionary.work.console.CheckWord;
import dictionary.work.console.InterfaceCheckWord;
import dictionary.work.console.View;

/**
 * Точка входа в программу
 */
public class Main {
    public static int argsCommandLine;
    private static final int ONE_FOR_COMMAND_LINE = 1;
    private static final int ZERO_FOR_COMMAND_LINE = 0;

    /**
     * Запуск консольного приложения и создание объектов для работы с ним
     *
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        argsCommandLine = parsCommandLineArgs(args);
        InterfaceCheckWord checkWord = new CheckWord();
        View view = new View(checkWord, createDictionary());
        view.startApp();
    }

    private static int parsCommandLineArgs(String[] args) {
        if (args.length > ZERO_FOR_COMMAND_LINE) {
            return argsCommandLine = ONE_FOR_COMMAND_LINE;
        } else {
            return argsCommandLine = ZERO_FOR_COMMAND_LINE;
        }
    }

    private static Dictionary createDictionary() {
        if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
            return new LocalDictionary();
        } else {
            return new RunTimeDictionary();
        }
    }
}