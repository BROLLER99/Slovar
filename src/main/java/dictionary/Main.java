package dictionary;

import dictionary.work.console.View;
import dictionary.work.console.commands.Invoker;

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
        Invoker invoker = new Invoker(createDictionary(args));
        View view = new View(invoker);
        view.startApp();
    }
}