package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;
/**
 * Класс реализует метод интерфейса Command поиском записи из словаря
 */
public class SearchCommand implements Command {
    private Dictionary storage;
    private String key;
    /**
     * Конструктор задает состояние объекта необходимыми параметрами поиска записи в словаре
     * @param storage - объект хранящий тип хранения словаря
     * @param key   - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public SearchCommand(Dictionary storage, String key) {
        this.storage = storage;
        this.key = key;

    }
    /**
     * Реализация метода выполнения команды(поиск записи) интерфейса Command
     */
    @Override
    public void execute() {
        if(storage.searchElement(key)){
            System.out.println("yes element");
        }
        else {
            System.out.println("no element");
        }
    }
}

