package dictionary;

import dictionary.work.console.CheckWord;
import dictionary.work.console.InterfaceCheckWord;
import dictionary.work.console.View;
import static dictionary.work.config.DictionaryConfig.createDictionary;


/**
 * Точка входа в программу
 */
public class Main {
    /**
     * Запуск консольного приложения и создание объектов для работы с ним
     *
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        InterfaceCheckWord checkWord = new CheckWord();
        View view = new View(checkWord, createDictionary(args));
        view.startApp();
    }
}