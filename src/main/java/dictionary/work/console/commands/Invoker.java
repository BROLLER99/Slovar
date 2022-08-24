package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

import java.io.Console;
import java.util.Scanner;

import static dictionary.work.console.View.getPattern;

/**
 * Класс для вызова команд словаря
 */
public class Invoker {
    private final Dictionary typeOfStorage;
    private Scanner scanner;
    private static final String KEY_WORD = "Ключ слово:";
    private static final String BAD_WORD = "Неправильно ввели слово";

    /**
     * Конструктор задает состояние объекта invoker
     *
     * @param typeOfStorage - объект хранящий тип хранения словаря
     */
    public Invoker(Dictionary typeOfStorage) {
        this.typeOfStorage = typeOfStorage;
    }

    /**
     * Метод обращается к команде AddCommand для выполнения запроса addElement
     */
    public void addElement() {
        Command addCommand = new AddCommand(typeOfStorage, checkWordCycle(), inputWord());
        addCommand.execute();
    }

    /**
     * Метод обращается к команде DeleteCommand для выполнения запроса deleteElement
     */
    public void deleteElement() {
        Command deleteCommand = new DeleteCommand(typeOfStorage, checkWordCycle());
        deleteCommand.execute();
    }

    /**
     * Метод обращается к команде SearchCommand для выполнения запроса searchElement
     */
    public void searchElement() {
        Command searchCommand = new SearchCommand(typeOfStorage, checkWordCycle());
        searchCommand.execute();
    }

    /**
     * Метод обращается к команде OutputAllCommand для выполнения запроса outputAllElements
     */
    public void outputAllElements() {
        Command outputAllCommand = new OutputAllCommand(typeOfStorage);
        outputAllCommand.execute();
    }

    /**
     * Метод получения введенного слова
     *
     * @return возвращает метод для введения слова
     */
    public String getInputWord() {
        return inputWord();
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
            System.out.println(KEY_WORD);
            keyWord = inputWord();
            if (keyWord.matches(getPattern())) {
                return keyWord;
            } else {
                System.out.println(BAD_WORD);
            }
        }
    }

}
