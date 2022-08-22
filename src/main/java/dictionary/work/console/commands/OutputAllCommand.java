package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;
/**
 * Класс реализует метод интерфейса Command выводом всех записей из словаря
 */
public class OutputAllCommand implements Command{
    private Dictionary storage;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для вывода всех записей из словаря
     * @param storage - объект хранящий тип хранения словаря
     */
    public OutputAllCommand(Dictionary storage) {
        this.storage = storage;
    }
    /**
     * Реализация метода выполнения команды(вывод всех записей) интерфейса Command
     */
    @Override
    public void execute() {
        System.out.println(storage.outputAllElements());
    }
}
