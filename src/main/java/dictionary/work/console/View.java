package dictionary.work.console;

import dictionary.work.config.StorageConfig;
import dictionary.work.console.commands.FactoryOfCommands;
import dictionary.work.console.commands.Invoker;
import dictionary.work.exeption.FileException;

import java.io.Console;
import java.util.Scanner;


/**
 * Класс для работы с пользователем через консоль, предоставляет пользователю выбор словаря и действий внутри него
 */

public class View {

    private static final String MAIN_MENU = "Выберете действие: \n1 - Словарь №1 \n2 - Словарь №2 \n0 - Выход из программы";
    private static final String DICTIONARY_MENU = "Выберете действие: \n1 - Просмотр всех пар слов \n2 - Добавить элемент \n3 - Удалить элемент \n4 - Поиск по ключу \n5 - Выйти из программы";
    private static final String MENU_EXCEPTION = "Выбран не существующий пункт!";
    private static int numberOfDictionary;
    private final Invoker invoker;
    private final StorageConfig storageConfig;
    private final FactoryOfCommands factoryOfCommands;
    private static String pattern;
    static Scanner scanner;

    /**
     * Конструктор задает состояние объекта view необходимыми параметрами
     *
     * @param invoker - объект для работы с запросами
     */
    public View(Invoker invoker, StorageConfig storageConfig, FactoryOfCommands factoryOfCommands) {
        this.invoker = invoker;
        this.storageConfig = storageConfig;
        this.factoryOfCommands = factoryOfCommands;
    }

    /**
     * Метод обеспечивает ввод-вывод в консоль запросов для работы со словарем
     */
    public void startApp() {
        {
            try {
                System.out.println(MAIN_MENU);
                String userChoice = getInputWord();
                pattern = storageConfig.getMapEntry(userChoice).getPattern();
                numberOfDictionary = Integer.parseInt(userChoice);
            } catch (NullPointerException e) {
                throw new FileException(MENU_EXCEPTION);
            }
        }
        while (true) {
            System.out.println(storageConfig.getMapEntry(numberOfDictionary + "").getDescription());
            System.out.println(DICTIONARY_MENU);

            int userChoice = Integer.parseInt(getInputWord());
            for (Commands c : Commands.values()) {
                if (c.getSerialNumberOfCommand() == userChoice) {
                    System.out.println(invoker.executeCommand(factoryOfCommands.nameOfCommand(c)));
                    break;
                }
            }
        }
    }

    /**
     * Метод геттер возвращает номер выбранного словаря
     *
     * @return numberOfDictionary - номер выбранного словаря
     */
    public static int getNumberOfDictionary() {
        return numberOfDictionary;
    }

    /**
     * Метод геттер возвращает паттерн выбранного словаря
     *
     * @return pattern - паттерн выбранного словаря
     */
    public static String getPattern() {
        return pattern;
    }

    private static Scanner getScanner() {
        if (scanner == null) {
            return new Scanner(System.in);
        } else return scanner;
    }

    /**
     * Метод получения введенного слова
     *
     * @return возвращает метод для введения слова
     */
    public static String getInputWord() {
        return inputWord();
    }

    private static String inputWord() {
        Console console = System.console();
        if (console == null) {
            return getScanner().nextLine();
        } else {
            return console.readLine();
        }
    }
}
