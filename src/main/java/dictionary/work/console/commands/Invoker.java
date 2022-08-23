package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

import java.io.Console;
import java.util.Scanner;

import static dictionary.work.console.View.getPattern;

/**
 * Класс для вызова команд словаря
 */
public class Invoker {
    private Dictionary storage;
    private Scanner scanner;

    /**
     * Конструктор задает состояние объекта invoker
     *
     * @param storage - объект хранящий тип хранения словаря
     */
    public Invoker(Dictionary storage) {
        this.storage = storage;
    }

    /**
     * Метод обращается к команде AddCommand для выполнения запроса addElement
     */
    public void addElement() {
        Command addCommand = new AddCommand(storage, checkWordCycle(), inputWord());
        addCommand.execute();
    }

    /**
     * Метод обращается к команде DeleteCommand для выполнения запроса deleteElement
     */
    public void deleteElement() {
        Command deleteCommand = new DeleteCommand(storage, checkWordCycle());
        deleteCommand.execute();
    }

    /**
     * Метод обращается к команде SearchCommand для выполнения запроса searchElement
     */
    public void searchElement() {
        Command searchCommand = new SearchCommand(storage, checkWordCycle());
        searchCommand.execute();
    }

    /**
     * Метод обращается к команде OutputAllCommand для выполнения запроса outputAllElements
     */
    public void outputAllElements() {
        Command outputAllCommand = new OutputAllCommand(storage);
        outputAllCommand.execute();
    }

    private String inputWord() {
        Console console = System.console();
        if (console == null) {
            return getScanner().nextLine();
        } else {
            return console.readLine();
        }
    }

    private Scanner getScanner() {
        if (scanner == null) {
            return new Scanner(System.in);
        } else return scanner;
    }

    private String checkWordCycle() {
        String keyWord;
        while (true) {
            System.out.println("KEY_WORD");
            keyWord = inputWord();
            if (keyWord.matches(getPattern())) {
                return keyWord;
            } else {
                System.out.println("BAD_WORD");
            }
        }
    }

}
