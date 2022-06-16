package dictionary.work.console;

import dictionary.work.map.Dictionary;
import dictionary.work.file.WorkFile;

import java.io.Console;
import java.util.Scanner;

import static dictionary.Main.argsCommandLine;

/**
 * Класс для работы с пользователем через консоль, предоставляет пользователю выбор словаря и действий внутри него
 */

public class Start {
    /**
     * Имя файла, содержащий ключи-слова
     */
    private static final String WORDS_FILE = "words.txt";
    /**
     * Имя файла, содержащий ключи-цифры
     */
    private static final String NUMBERS_FILE = "chisla.txt";
    private static final String EXIT_PROGRAM = "Выход из программы. ";
    private static final String DOES_NOT_EXIST = "Такого пункта меню не существует! ";
    private static final String KEY_WORD = "Ключ слово: ";
    private static final String VALUE = "Слово перевод ";
    private static final String ADD_ENTRY = "Добавлена запись: ";
    private static final String DELETE = " удалено ";
    private static final String ALL_WORDS = "Все слова выведенны: ";
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static final String BAD_WORD = "Недопустимое слово.";
    private static final String YES_ELEMENT = "Такой элемент есть! ";
    private static final String NO_ELEMENT = "Такого элемента нет ";
    private static final String SPACE = " ";
    private static final int ONE_FOR_USER_CHOICE = 1;
    private static final int TWO_FOR_USER_CHOICE = 2;
    private static final int ZERO_FOR_USER_CHOICE = 0;
    private static final int ONE_FOR_COMMAND_LINE = 1;
    private static final int ONE_FOR_NUMBER_OF_DICTIONARY = 1;
    private static final int TWO_FOR_NUMBER_OF_DICTIONARY = 1;
    private static final String FIRST_PATTERN = "[a-zA-Z]{4}";
    private static final String SECOND_PATTERN = "[0-9]{5}";
    int numberOfDictionary;
    Menu menu = new Menu();
    CheckWord checkWord = new CheckWord();
    Dictionary dictionary = new Dictionary();

    WorkFile workFile = new WorkFile();
    String pattern;

    /**
     * Метод предоставляет пользователю выбор действия из главного меню.
     */
    public void chooseDictionary() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.mainMenu();
            int userChoice = scanner.nextInt();
            if (userChoice == ONE_FOR_USER_CHOICE) {
                pattern = FIRST_PATTERN;
                if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                    workFile.read(WORDS_FILE);
                }
                numberOfDictionary = ONE_FOR_NUMBER_OF_DICTIONARY;
                break;
            } else if (userChoice == TWO_FOR_USER_CHOICE) {
                pattern = SECOND_PATTERN;
                if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                    workFile.read(NUMBERS_FILE);
                }
                numberOfDictionary = TWO_FOR_NUMBER_OF_DICTIONARY;
                break;
            } else if (userChoice == ZERO_FOR_USER_CHOICE) {
                System.out.println(EXIT_PROGRAM);
                System.exit(0);
                break;
            } else
                System.out.println(DOES_NOT_EXIST);
            System.out.println();
        }
    }

    /**
     * Метод предоставляет пользователю выбор действия из меню словаря
     */
    public void chooseAction() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
                menu.firstDictionary();
            } else menu.secondDictionary();

            menu.dictionaryMenu();
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println(ALL_WORDS);
                    System.out.println(dictionary.outputAllElements());

                    break;
                case 2:
                    String keyWord = checkWordCycle();
                    System.out.println(VALUE);
                    String valueWord = inputWord();
                    dictionary.addElement(keyWord, valueWord);
                    System.out.println(ADD_ENTRY + keyWord + KEY_VALUE_SEPARATOR + valueWord);
                    System.out.println();
                    if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
                        if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                            workFile.write(WORDS_FILE);
                        }
                    } else {
                        if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                            workFile.write(NUMBERS_FILE);
                        }
                    }
                    break;
                case 3:
                    String keyDelete = checkWordCycle();
                    dictionary.deleteElement(keyDelete);
                    System.out.println(KEY_WORD + keyDelete + DELETE);
                    System.out.println();
                    if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
                        if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                            workFile.write(WORDS_FILE);
                        }
                    } else {
                        if (argsCommandLine == ONE_FOR_COMMAND_LINE) {
                            workFile.write(NUMBERS_FILE);
                        }
                    }
                    break;
                case 4:
                    String keySearch = checkWordCycle();
                    if (dictionary.searchElement(keySearch)) {
                        System.out.println(YES_ELEMENT);
                    } else System.out.println(NO_ELEMENT);
                    System.out.print(KEY_WORD + keySearch + SPACE + VALUE);
                    System.out.println(dictionary.outputElement(keySearch));
                    System.out.println();
                    break;
                case 5:
                    System.out.println(EXIT_PROGRAM);
                    System.exit(0);
                default:
                    System.out.println(DOES_NOT_EXIST);
                    System.out.println();
            }
        }
    }

    private String inputWord() {
        Console console = System.console();
        if (console == null) {
            Scanner scan_value = new Scanner(System.in);
            return scan_value.nextLine();
        } else {
            return console.readLine();
        }

    }

    private String checkWordCycle() {
        String keyWord;
        while (true) {
            System.out.println(KEY_WORD);
            keyWord = inputWord();
            if (checkWord.check(pattern, keyWord)) { //TODO
                return keyWord;
            } else {
                System.out.println(BAD_WORD);
            }
        }
    }
}
