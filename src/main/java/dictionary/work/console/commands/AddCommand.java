package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

/**
 * Класс реализует метод интерфейса Command добавлением записи в словарь
 */

public class AddCommand implements Command {
    private Dictionary storage;
    private String key;
    private String value;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для записи значения в словарь
     * @param storage - объект хранящий тип хранения словаря
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     */
    public AddCommand(Dictionary storage, String key, String value) {
        this.storage = storage;
        this.key = key;
        this.value = value;
    }

    /**
     * Реализация метода выполнения команды(добавление записи в словарь) интерфейса Command
     */
    @Override
    public void execute() {
        storage.addElement(key, value);
    }
}
