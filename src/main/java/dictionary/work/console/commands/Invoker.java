package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

/**
 * Класс для вызова команд словаря
 */
public class Invoker {
    private Dictionary storage;

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
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     */
    public void addElement(String key, String value) {
        Command addCommand = new AddCommand(storage, key, value);
        addCommand.execute();
    }

    /**
     * Метод обращается к команде DeleteCommand для выполнения запроса deleteElement
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо добавить
     */
    public void deleteElement(String key) {
        Command deleteCommand = new DeleteCommand(storage, key);
        deleteCommand.execute();
    }

    /**
     * Метод обращается к команде SearchCommand для выполнения запроса searchElement
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо добавить
     */
    public void searchElement(String key) {
        Command searchCommand = new SearchCommand(storage, key);
        searchCommand.execute();
    }

    /**
     * Метод обращается к команде OutputAllCommand для выполнения запроса outputAllElements
     */
    public void outputAllElements() {
        Command outputAllCommand = new OutputAllCommand(storage);
        outputAllCommand.execute();
    }

    /**
     * Метод обращается к команде SetNumberOfDictionaryCommand для выполнения запроса setNumberOfDictionary
     *
     * @param numberOfDictionary - аргумент, хранящий номер словаря
     */
    public void setNumberOfDictionary(int numberOfDictionary) {
        Command setNumberOfDictionaryCommand = new SetNumberOfDictionaryCommand(storage, numberOfDictionary);
        setNumberOfDictionaryCommand.execute();
    }
}
