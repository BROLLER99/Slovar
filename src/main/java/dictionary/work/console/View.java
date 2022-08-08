package dictionary.work.console;

import dictionary.work.exeption.FileException;
import dictionary.work.file.InterfaceWorkFile;
import dictionary.work.map.InterfaceDictionary;
import dictionary.work.map.Dictionary;
import dictionary.work.file.WorkFile;

import java.io.Console;
import java.util.Objects;
import java.util.Scanner;

import static dictionary.Main.argsCommandLine;

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
    private static final String KEY_WORD = "Ключ слово: ";
    private static final String VALUE = "Слово перевод ";
    private static final String ADD_ENTRY = "Добавлена запись: %s %s %s %n";
    private static final String DELETE = " удалено ";
    private static final String ALL_WORDS = "Все слова выведены: ";
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String BAD_WORD = "Недопустимое слово.";
    private static final String YES_ELEMENT = "Такой элемент есть! ";
    private static final String NO_ELEMENT = "Такого элемента нет ";
    private static final String SPACE = " ";
    private static final String ONE_FOR_USER_CHOICE_IN_MAIN_MENU = "1";
    private static final String TWO_FOR_USER_CHOICE_IN_MAIN_MENU = "2";
    private static final String ZERO_FOR_USER_CHOICE_IN_MAIN_MENU = "0";
    private static final int ONE_FOR_COMMAND_LINE = 1;
    private static final int FIRST_NUMBER_OF_DICTIONARY = 1;
    private static final int SECOND_NUMBER_OF_DICTIONARY = 2;
    private static final String FIRST_PATTERN = "[a-zA-Z]{4}";
    private static final String SECOND_PATTERN = "[0-9]{5}";
    private static final int ZERO_FOR_EXIT = 0;
    private static final String ONE_FOR_CHOICE_IN_DICTIONARY_MENU = "1";
    private static final String TWO_FOR_CHOICE_IN_DICTIONARY_MENU = "2";
    private static final String THREE_FOR_CHOICE_IN_DICTIONARY_MENU = "3";
    private static final String FOUR_FOR_CHOICE_IN_DICTIONARY_MENU = "4";
    private static final String FIVE_FOR_CHOICE_IN_DICTIONARY_MENU = "5";
    private int numberOfDictionary;
    InterfaceCheckWord checkWord = new CheckWord();
    InterfaceDictionary dictionary = new Dictionary();
    InterfaceWorkFile workFile = new WorkFile();
    private String pattern;
    private Scanner scanner;

    /**
     * Метод предоставляет пользователю выбор действия из главного меню.
     *
     * @throws FileException возникает при наличии следующий исключений:IllegalArgumentException
     *                       NullPointerException
     *                       ClassCastException
     *                       UnsupportedOperationException
     *                       IOException
     */
    public void chooseDictionary() {
        try {
            while (true) {
                System.out.println(MAIN_MENU);
                String userChoice = inputWord();
                if (Objects.equals(userChoice, ONE_FOR_USER_CHOICE_IN_MAIN_MENU)) {
                    pattern = FIRST_PATTERN;
                    if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                        numberOfDictionary = FIRST_NUMBER_OF_DICTIONARY;
                        workFile.read(FIRST_NUMBER_OF_DICTIONARY);
                    }
                    break;
                } else if (Objects.equals(userChoice, TWO_FOR_USER_CHOICE_IN_MAIN_MENU)) {
                    pattern = SECOND_PATTERN;
                    if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                        numberOfDictionary = SECOND_NUMBER_OF_DICTIONARY;
                        workFile.read(SECOND_NUMBER_OF_DICTIONARY);
                    }
                    break;
                } else if (Objects.equals(userChoice, ZERO_FOR_USER_CHOICE_IN_MAIN_MENU)) {
                    System.out.println(EXIT_PROGRAM);
                    System.exit(ZERO_FOR_EXIT);
                    break;
                } else
                    System.out.println(DOES_NOT_EXIST);
                System.out.println();
            }
        } catch (FileException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод предоставляет пользователю выбор действия из меню словаря
     */
    public void chooseAction() {
        while (true) {
            if (numberOfDictionary == FIRST_NUMBER_OF_DICTIONARY) {
                System.out.println(FIRST_DICTIONARY_AND_TERMS);
            } else System.out.println(SECOND_DICTIONARY_AND_TERMS);
            try {
                System.out.println(DICTIONARY_MENU);
                String userChoice = inputWord();
                switch (userChoice) {
                    case ONE_FOR_CHOICE_IN_DICTIONARY_MENU:
                        System.out.println(ALL_WORDS);
                        System.out.println(dictionary.outputAllElements());
                        break;
                    case TWO_FOR_CHOICE_IN_DICTIONARY_MENU:
                        String keyWord = checkWordCycle();
                        System.out.println(VALUE);
                        String valueWord = inputWord();
                        dictionary.addElement(keyWord, valueWord);
                        System.out.printf(ADD_ENTRY, keyWord, KEY_VALUE_SEPARATOR, valueWord);
                        System.out.println();
                        tryException();
                        break;
                    case THREE_FOR_CHOICE_IN_DICTIONARY_MENU:
                        String keyDelete = checkWordCycle();
                        dictionary.deleteElement(keyDelete);
                        System.out.println(KEY_WORD + keyDelete + DELETE);
                        System.out.println();
                        tryException();
                        break;
                    case FOUR_FOR_CHOICE_IN_DICTIONARY_MENU:
                        String keySearch = checkWordCycle();
                        if (dictionary.searchElement(keySearch)) {
                            System.out.println(YES_ELEMENT);
                        } else System.out.println(NO_ELEMENT);
                        System.out.print(KEY_WORD + keySearch + SPACE + VALUE);
                        System.out.println(dictionary.outputElement(keySearch));
                        System.out.println();
                        break;
                    case FIVE_FOR_CHOICE_IN_DICTIONARY_MENU:
                        System.out.println(EXIT_PROGRAM);
                        System.exit(ZERO_FOR_EXIT);
                    default:
                        System.out.println(DOES_NOT_EXIST);
                        System.out.println();
                }
            } catch (FileException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Метод проверки на наличие исключения
     *
     * @throws FileException возникает при появлении исключения IOException
     */
    private void tryException() {
        try {
            if (numberOfDictionary == FIRST_NUMBER_OF_DICTIONARY) {
                if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                    workFile.write(FIRST_NUMBER_OF_DICTIONARY);
                }
            } else {
                if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                    workFile.write(SECOND_NUMBER_OF_DICTIONARY);
                }
            }
        } catch (FileException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод запрашивает пользовательский ввод
     *
     * @return возвращает значение введенное пользователем
     */
    private String inputWord() {
        Console console = System.console();
        if (console == null) {
            return createScanner().nextLine();
        } else {
            return console.readLine();
        }
    }

    /**
     * Метод проверяет наличие Scanner и создает его если его нет
     *
     * @return возвращает Scanner в зависимости от условия
     */
    private Scanner createScanner() {
        if (scanner == null) {
            return new Scanner(System.in);
        } else return scanner;
    }

    /**
     * Метод запрашивает пользовательский ввод до тех пор, пока не будет введено правильное слово
     *
     * @return возвращает значение правильно введенного слова
     */
    private String checkWordCycle() {
        String keyWord;
        while (true) {
            System.out.println(KEY_WORD);
            keyWord = inputWord();
            if (checkWord.check(pattern, keyWord)) {
                return keyWord;
            } else {
                System.out.println(BAD_WORD);
            }
        }
    }
}
