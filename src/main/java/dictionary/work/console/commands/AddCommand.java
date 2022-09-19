package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;


/**
 * Класс реализует метод интерфейса Command добавлением записи в словарь
 */
public class AddCommand<T> implements Command<String> {
    private final Dictionary typeOfStorage;
    private final String keyWord;
    private final String valueWord;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для записи значения в словарь
     * @param typeOfStorage - объект хранящий тип хранения словаря
     * @param keyWord   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param valueWord - аргумент, хранящий слово - значение, который необходимо добавить
     */
    public AddCommand(Dictionary typeOfStorage, String keyWord, String valueWord) {
        this.typeOfStorage = typeOfStorage;
        this.keyWord = keyWord;
        this.valueWord = valueWord;
    }

    /**
     * Реализация метода выполнения команды(добавление записи в словарь) интерфейса Command
     */
    @Override
    public String execute() {
        typeOfStorage.addElement(keyWord, valueWord);
        return COMPLETE;
    }
}
