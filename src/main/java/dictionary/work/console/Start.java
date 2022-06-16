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
    private static final String YES_ELEMENT = "Такой элемент есть! ";
    private static final String NO_ELEMENT = "Такого элемента нет ";
    private static final String SPACE = " ";
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
            if (userChoice == 1) {
                pattern = "[a-zA-Z]{4}";
                if (argsCommandLine == 1) {
                    workFile.read(WORDS_FILE);
                }
                numberOfDictionary = 1;
                break;
            } else if (userChoice == 2) {
                pattern = "[0-9]{5}";
                if (argsCommandLine == 1) {
                    workFile.read(NUMBERS_FILE);
                }
                numberOfDictionary = 2;
                break;
            } else if (userChoice == 0) {
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
            if (numberOfDictionary == 1) {
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
                    String keyWord = prov();
                    System.out.println(VALUE);
                    String valueWord = inputWord();
                    dictionary.addElement(keyWord, valueWord);
                    System.out.println(ADD_ENTRY + keyWord + KEY_VALUE_SEPARATOR + valueWord);
                    System.out.println();
                    if (numberOfDictionary == 1) {
                        if (argsCommandLine == 1) {
                            workFile.write(WORDS_FILE);
                        }
                    } else {
                        if (argsCommandLine == 1) {
                            workFile.write(NUMBERS_FILE);
                        }
                    }
                    break;
                case 3:
                    String keyDelete = prov();
                    dictionary.deleteElement(keyDelete);
                    System.out.println(KEY_WORD + keyDelete + DELETE);
                    System.out.println();
                    if (numberOfDictionary == 1) {
                        if (argsCommandLine == 1) {
                            workFile.write(WORDS_FILE);
                        }
                    } else {
                        if (argsCommandLine == 1) {
                            workFile.write(NUMBERS_FILE);
                        }
                    }
                    break;
                case 4:
                    String keySearch = prov();
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

    private String prov() {//TODO rename
        String keyWord;
        while (true) {
            System.out.println(KEY_WORD);
            keyWord = inputWord();
            if (checkWord.check(pattern, keyWord)) { //TODO
                return keyWord;
            } else {
                System.out.println("Недопустимое слово.");//TODO const
            }
        }
    }
}
