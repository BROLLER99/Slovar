package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;

/**
 * Класс реализует метод интерфейса Command удалением записи из словаря
 */
public class DeleteCommand implements Command {
    private final Dictionary typeOfStorage;
    private final String keyWord;
    /**
     * Конструктор задает состояние объекта необходимыми параметрами для удаления записи из словаря
     * @param typeOfStorage - объект хранящий тип хранения словаря
     * @param keyWord   - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public DeleteCommand(Dictionary typeOfStorage, String keyWord) {
        this.typeOfStorage = typeOfStorage;
        this.keyWord=keyWord;
    }
    /**
     * Реализация метода выполнения команды(удаление записи) интерфейса Command
     */
    @Override
    public void execute(){
        typeOfStorage.deleteElement(keyWord);
    }
}
