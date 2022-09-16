package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;


import static dictionary.work.console.View.getInputWord;
import static dictionary.work.console.View.getPattern;

/**
 * Класс для вызова команд словаря
 */
public class Invoker {
    private final Dictionary typeOfStorage;
    private static final String KEY_WORD = "Ключ слово:";
    private static final String BAD_WORD = "Неправильно ввели слово";
    private static final int ZERO_FOR_EXIT = 0;

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
     * @return
     */
    public String addElement() {
        Command addCommand = new AddCommand(typeOfStorage, checkWordCycle(), getInputWord());
        return (String) addCommand.execute();
    }

    /**
     * Метод обращается к команде DeleteCommand для выполнения запроса deleteElement
     *
     * @return
     */
    public String deleteElement() {
        Command deleteCommand = new DeleteCommand(typeOfStorage, checkWordCycle());
        return (String) deleteCommand.execute();
    }

    /**
     * Метод обращается к команде SearchCommand для выполнения запроса searchElement
     * @return
     */
    public String searchElement() {
        Command<String> searchCommand = new SearchCommand(typeOfStorage, checkWordCycle());
        return searchCommand.execute();
    }

    /**
     * Метод обращается к команде OutputAllCommand для выполнения запроса outputAllElements
     * @return
     */
    public StringBuilder outputAllElements() {
        Command<StringBuilder> outputAllCommand = new OutputAllCommand(typeOfStorage);
        return outputAllCommand.execute();
    }
    /**
     * Метод выхода из программы
     */
    public void exit() {
        System.exit(ZERO_FOR_EXIT);
    }

    private String checkWordCycle() {
        String keyWord;
        while (true) {
            System.out.println(KEY_WORD);
            keyWord = getInputWord();
            if (keyWord.matches(getPattern())) {
                return keyWord;
            } else {
                System.out.println(BAD_WORD);
            }
        }
    }

}
