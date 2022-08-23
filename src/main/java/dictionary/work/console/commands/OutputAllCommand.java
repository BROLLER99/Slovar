package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;
/**
 * Класс реализует метод интерфейса Command выводом всех записей из словаря
 */
public class OutputAllCommand implements Command{
    private final Dictionary typeOfStorage;

    /**
     * Конструктор задает состояние объекта необходимыми параметрами для вывода всех записей из словаря
     * @param typeOfStorage - объект хранящий тип хранения словаря
     */
    public OutputAllCommand(Dictionary typeOfStorage) {
        this.typeOfStorage = typeOfStorage;
    }
    /**
     * Реализация метода выполнения команды(вывод всех записей) интерфейса Command
     */
    @Override
    public void execute() {
        System.out.println(typeOfStorage.outputAllElements());
    }
}
