package main;

import dictionary.Dictionary;
import dictionary.WorkFile;

import java.util.Scanner;

import static main.Main.argsCommandLine;


public class Start {
    private static final String WORDS_FILE = "words.txt";
    private static final String NUMBERS_FILE = "chisla.txt";
    int numberOfDictionary;
    Menu menu = new Menu();
    Check check = new Check();
    Dictionary dictionary = new Dictionary();
    Dictionary dictionary2 = new Dictionary();

    WorkFile wf = new WorkFile();
    String pattern;
    public void chooseDictionary() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu.mainMenu();
            int mm = sc.nextInt();
            if (mm==1){
                pattern = "[a-zA-Z]{4}";
                if (argsCommandLine == 1) {
                        wf.read(WORDS_FILE);
                    }
                    numberOfDictionary = 1;
                    break;
            }
            else if(mm==2){
                pattern = "[0-9]{5}";
                if (argsCommandLine == 1) {
                        wf.read(NUMBERS_FILE);
                    }
                    numberOfDictionary = 2;
                    break;
            }
            else if (mm==0){
                System.out.println("Выход из программы.");
                    System.exit(0);
                    break;
            }
            else
                System.out.println("Такого пункта меню не существует!");
                System.out.println();
        }
   }
    public void сhooseAction(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            if(numberOfDictionary==1) {
                menu.firstDictionary();
            }
            else menu.secondDictionary();

            menu.dictionaryMenu();
            int sm1 = sc.nextInt();
            switch (sm1) {
                case 1:
                    dictionary.allElements();
                    break;
                case 2:
                    System.out.println("Введите новый ключ и слово перевод");
                    String keyWord = check.checkDictionary(numberOfDictionary, pattern);
                    System.out.println("Слово перевод");
                    String valueWord = check.checkConsole();
                    dictionary.add(keyWord, valueWord);
                    System.out.println("Добавлена запись: " + keyWord + " : " + valueWord);
                    System.out.println();
                    if (numberOfDictionary==1) {
                        if (argsCommandLine == 1) {
                            wf.write(WORDS_FILE);
                        }
                    }
                    else if(argsCommandLine==1) {
                        wf.write(NUMBERS_FILE);
                    }
                    break;
                case 3:
                    System.out.println("Введите ключ удаляемого слова:");
                    String keyDelete = check.checkDictionary(numberOfDictionary, pattern);
                    dictionary.delete(keyDelete);
                    System.out.println("Слово с ключем " + keyDelete + " удалено");
                    System.out.println();
                    if (numberOfDictionary==1) {
                        if (argsCommandLine == 1) {
                            wf.write(WORDS_FILE);
                        }
                    }
                    else if(argsCommandLine==1) {
                        wf.write(NUMBERS_FILE);
                    }
                    break;
                case 4:
                    System.out.println("Введите ключ слова, которое нужно найти");
                    String keySearch = check.checkDictionary(numberOfDictionary, pattern);
                    dictionary.search(keySearch);
                    System.out.print("Ключ: " + keySearch + " Cлово: ");
                    System.out.println(dictionary.out(keySearch));
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
