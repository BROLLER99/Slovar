package dictionary;

import dictionary.work.DAO.LocalDictionary;
import dictionary.work.DAO.RunTimeDictionary;
import dictionary.work.console.CheckWord;
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
        if (args.length > ZERO_FOR_COMMAND_LINE) {
            argsCommandLine = ONE_FOR_COMMAND_LINE;
        } else argsCommandLine = ZERO_FOR_COMMAND_LINE;
        CheckWord checkWord = new CheckWord();
        LocalDictionary localDictionary = new LocalDictionary();
        RunTimeDictionary runTimeDictionary = new RunTimeDictionary();
        View view = new View(checkWord, runTimeDictionary, localDictionary);
        view.startWorkingWithDictionary();
    }
}