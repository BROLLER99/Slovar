package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;
/**
 * Класс реализует метод интерфейса Command установкой номера словаря
 */
public class SetNumberOfDictionaryCommand implements Command{
    private Dictionary storage;
    private int numberOfDictionary;
    /**
     * Конструктор задает состояние объекта необходимыми параметрами установкой номера словаря
     * @param storage - объект хранящий тип хранения словаря
     * @param numberOfDictionary - аргумент, хранящий номер словаря
     */
    public SetNumberOfDictionaryCommand(Dictionary storage, int numberOfDictionary) {
        this.storage = storage;
        this.numberOfDictionary=numberOfDictionary;
    }
    /**
     * Реализация метода выполнения команды(установка номера словаря) интерфейса Command
     */
    @Override
    public void execute() {
        storage.setNumberOfDictionary(numberOfDictionary);
    }
}
