package programm;

import dictionary.Dictionary;
import dictionary.WorkFile;

import java.util.Scanner;

import static programm.Main.argsCommandLine;


public class Start {
    private static final String WORDS_FILE = "words.txt";
    private static final String NUMBERS_FILE = "chisla.txt";
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
                System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
            }
            else
                System.out.println("Такого пункта меню не существует!");
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
                    dictionary.outputAllElements();
                    break;
                case 2:
                    System.out.println("Введите новый ключ и слово перевод");
                    String keyWord = check.checkDictionary(numberOfDictionary, pattern);
                    System.out.println("Слово перевод");
                    String valueWord = check.checkConsole();
                    dictionary.addElement(keyWord, valueWord);
                    System.out.println("Добавлена запись: " + keyWord + " : " + valueWord);
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
                    System.out.println("Введите ключ удаляемого слова:");
                    String keyDelete = check.checkDictionary(numberOfDictionary, pattern);
                    dictionary.deleteElement(keyDelete);
                    System.out.println("Слово с ключем " + keyDelete + " удалено");
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
                    System.out.println("Введите ключ слова, которое нужно найти");
                    String keySearch = check.checkDictionary(numberOfDictionary, pattern);
                    dictionary.searchElement(keySearch);
                    System.out.print("Ключ: " + keySearch + " Cлово: ");
                    System.out.println(dictionary.outputElement(keySearch));
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Выход из программы");
                    System.exit(0);
                default:
                    System.out.println("Такого пункта меню не существует!");
                    System.out.println();
            }
        }
    }
}
