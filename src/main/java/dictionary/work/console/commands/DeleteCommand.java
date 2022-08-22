package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

/**
 * Класс реализует метод интерфейса Command удалением записи из словаря
 */
public class DeleteCommand implements Command {
    private Dictionary storage;
    private String key;
    /**
     * Конструктор задает состояние объекта необходимыми параметрами для удаления записи из словаря
     * @param storage - объект хранящий тип хранения словаря
     * @param key   - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public DeleteCommand(Dictionary storage, String key) {
        this.storage = storage;
        this.key=key;
    }
    /**
     * Реализация метода выполнения команды(удаление записи) интерфейса Command
     */
    @Override
    public void execute(){
        storage.deleteElement(key);
    }
}
