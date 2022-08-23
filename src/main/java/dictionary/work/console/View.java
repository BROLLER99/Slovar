package dictionary.work.console;

import dictionary.work.console.commands.Invoker;
import dictionary.work.exeption.FileException;
import java.util.Objects;


/**
 * Класс для работы с пользователем через консоль, предоставляет пользователю выбор словаря и действий внутри него
 */

public class View {

    private static final String MAIN_MENU = "Выберете действие: \n1 - Словарь №1 \n2 - Словарь №2 \n0 - Выход из программы";
    private static final String DICTIONARY_MENU = "Выберете действие: \n1 - Просмотр всех пар слов \n2 - Добавить элемент \n3 - Удалить элемент \n4 - Поиск по ключу \n5 - Выйти из программы";
    private static final String FIRST_DICTIONARY_AND_TERMS = "Выбран словарь № 1. \nВ данном словаре длинна слов может быть только 4 символа и эти символы только буквы латинской раскладки";
    private static final String SECOND_DICTIONARY_AND_TERMS = "Выбран словарь № 2. \nВ данном словаре длина слов может быть только 5 символа и эти символы только цифры.";
    private static final String EXIT_PROGRAM = "Выход из программы. ";
    private static final String DOES_NOT_EXIST = "Такого пункта меню не существует! ";
    private static final String ONE_FOR_USER_CHOICE_IN_MAIN_MENU = "1";
    private static final String TWO_FOR_USER_CHOICE_IN_MAIN_MENU = "2";
    private static final String ZERO_FOR_USER_CHOICE_IN_MAIN_MENU = "0";
    private static final int FIRST_NUMBER_OF_DICTIONARY = 1;
    private static final int SECOND_NUMBER_OF_DICTIONARY = 2;
    private static final String FIRST_PATTERN = "[a-zA-Z]{4}";
    private static final String SECOND_PATTERN = "[0-9]{5}";
    private static final int ZERO_FOR_EXIT = 0;
    private static final int NUMBER_FOR_OUTPUT_ALL_ELEMENTS = 1;
    private static final int NUMBER_FOR_ADD_ELEMENT = 2;
    private static final int NUMBER_FOR_DELETE_ELEMENT = 3;
    private static final int NUMBER_FOR_SEARCH_ELEMENT = 4;
    private static final int NUMBER_FOR_EXIT = 5;

    private static int numberOfDictionary;
    private final Invoker invoker;
    private static String pattern;

    /**
     * Конструктор задает состояние объекта view необходимыми параметрами
     *
     * @param invoker - объект для работы с запросами
     */
    public View(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Метод обеспечивает ввод-вывод в консоль запросов для работы со словарем
     */
    public void startApp() {
        while (true) {
            System.out.println(MAIN_MENU);
            String userChoice = invoker.inputWords();

            if (Objects.equals(userChoice, ONE_FOR_USER_CHOICE_IN_MAIN_MENU)) {
                pattern = FIRST_PATTERN;
                numberOfDictionary = FIRST_NUMBER_OF_DICTIONARY;
                break;
            } else if (Objects.equals(userChoice, TWO_FOR_USER_CHOICE_IN_MAIN_MENU)) {
                pattern = SECOND_PATTERN;
                numberOfDictionary = SECOND_NUMBER_OF_DICTIONARY;
                break;
            } else if (Objects.equals(userChoice, ZERO_FOR_USER_CHOICE_IN_MAIN_MENU)) {
                System.out.println(EXIT_PROGRAM);
                System.exit(ZERO_FOR_EXIT);
                break;
            } else
                System.out.println(DOES_NOT_EXIST);
            System.out.println();
        }
        while (true) {
            try {
                if (numberOfDictionary == FIRST_NUMBER_OF_DICTIONARY) {
                    System.out.println(FIRST_DICTIONARY_AND_TERMS);
                } else System.out.println(SECOND_DICTIONARY_AND_TERMS);
                System.out.println(DICTIONARY_MENU);

                int userChoice = Integer.parseInt(invoker.inputWords());
                Commands[] commands = Commands.values();
                for (Commands c : commands) {
                    if (c.getNumberOfCommand() == userChoice) {
                        if (c.getNumberOfCommand() == NUMBER_FOR_OUTPUT_ALL_ELEMENTS) {
                            invoker.outputAllElements();
                        } else if (c.getNumberOfCommand() == NUMBER_FOR_ADD_ELEMENT) {
                            invoker.addElement();
                        } else if (c.getNumberOfCommand() == NUMBER_FOR_DELETE_ELEMENT) {
                            invoker.deleteElement();
                        } else if (c.getNumberOfCommand() == NUMBER_FOR_SEARCH_ELEMENT) {
                            invoker.searchElement();
                        } else if (c.getNumberOfCommand() == NUMBER_FOR_EXIT) {
                            System.exit(ZERO_FOR_EXIT);
                        }
                    }
                }
            } catch (FileException e) {
                System.out.println(e.getMessage());
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
}