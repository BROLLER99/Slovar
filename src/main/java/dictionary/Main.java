package dictionary;

import dictionary.work.Model.ModelOfCommand;
import dictionary.work.config.DictionaryConfig;
import dictionary.work.console.View;
import dictionary.work.console.commands.FactoryOfCommands;

import static dictionary.work.config.StorageConfig.createStorage;


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
        ModelOfCommand modelOfCommand = new ModelOfCommand();
        FactoryOfCommands factoryOfCommands = new FactoryOfCommands(createStorage(args));
        DictionaryConfig dictionaryConfig = new DictionaryConfig();
        View view = new View(dictionaryConfig, factoryOfCommands, modelOfCommand);
        view.startApp();
    }
}