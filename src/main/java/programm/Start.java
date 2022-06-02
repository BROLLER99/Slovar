package programm;

import dictionary.Dictionary;
import dictionary.WorkFile;

import java.util.Scanner;

import static programm.Main.argsCommandLine;

/**
 * Класс работы с пользователем через консль, предоставляет выбор словаря и действия внутри него
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
    private static final String YES_ELEMENT ="Такой элемент есть! ";
    private static final String NO_ELEMENT ="Такого элемента нет ";
    private static final String SPACE = " ";

    int numberOfDictionary;
    Menu menu = new Menu();
    Check check = new Check();
    Dictionary dictionary = new Dictionary();

    WorkFile workFile = new WorkFile();
    String pattern;
    public void chooseDictionary() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.mainMenu();
            int userChoice = scanner.nextInt();
            if (userChoice==1){
                pattern = "[a-zA-Z]{4}";
                if (argsCommandLine == 1) {
                        workFile.read(WORDS_FILE);
                    }
                    numberOfDictionary = 1;
                    break;
            }
            else if(userChoice==2){
                pattern = "[0-9]{5}";
                if (argsCommandLine == 1) {
                        workFile.read(NUMBERS_FILE);
                    }
                    numberOfDictionary = 2;
                    break;
            }
            else if (userChoice==0){
                System.out.println(EXIT_PROGRAM);
                    System.exit(0);
                    break;
            }
            else
                System.out.println(DOES_NOT_EXIST);
                System.out.println();
        }
   }
    public void chooseAction(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if(numberOfDictionary==1) {
                menu.firstDictionary();
            }
            else menu.secondDictionary();

            menu.dictionaryMenu();
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println(ALL_WORDS);
                    System.out.println(dictionary.outputAllElements());

                    break;
                case 2:
                    String keyWord = check.checkDictionary(numberOfDictionary, pattern);
                    System.out.println(VALUE);
                    String valueWord = check.checkConsole();
                    dictionary.addElement(keyWord, valueWord);
                    System.out.println(ADD_ENTRY + keyWord + KEY_VALUE_SEPARATOR + valueWord);
                    System.out.println();
                    if (numberOfDictionary==1) {
                        if (argsCommandLine == 1) {
                            workFile.write(WORDS_FILE);
                        }
                    }
                    else {
                        if (argsCommandLine == 1) {
                            workFile.write(NUMBERS_FILE);
                        }
                    }
                    break;
                case 3:
                    String keyDelete = check.checkDictionary(numberOfDictionary, pattern);
                    dictionary.deleteElement(keyDelete);
                    System.out.println(KEY_WORD + keyDelete + DELETE);
                    System.out.println();
                    if (numberOfDictionary==1) {
                        if (argsCommandLine == 1) {
                            workFile.write(WORDS_FILE);
                        }
                    }
                    else {
                        if (argsCommandLine == 1) {
                            workFile.write(NUMBERS_FILE);
                        }
                    }
                    break;
                case 4:
                    String keySearch = check.checkDictionary(numberOfDictionary, pattern);
                    if(dictionary.searchElement(keySearch)){
                        System.out.println(YES_ELEMENT);
                    }
                    else System.out.println(NO_ELEMENT);
                    System.out.print(KEY_WORD + keySearch + SPACE +VALUE);
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
}
