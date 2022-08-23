package dictionary.work.console.commands;

import dictionary.work.DAO.Dictionary;
/**
 * Класс реализует метод интерфейса Command поиском записи из словаря
 */
public class SearchCommand implements Command {
    private final Dictionary typeOfStorage;
    private final String keyWord;
    private static final String YES_ELEMENT = "Такой элемент есть";
    private static final String NO_ELEMENT = "Такого элемента нет";

    /**
     * Конструктор задает состояние объекта необходимыми параметрами поиска записи в словаре
     * @param typeOfStorage - объект хранящий тип хранения словаря
     * @param keyWord   - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    public SearchCommand(Dictionary typeOfStorage, String keyWord) {
        this.typeOfStorage = typeOfStorage;
        this.keyWord = keyWord;

    }
    /**
     * Реализация метода выполнения команды(поиск записи) интерфейса Command
     */
    @Override
    public void execute() {
        if(typeOfStorage.searchElement(keyWord)){
            System.out.println(YES_ELEMENT);
        }
        else {
            System.out.println(NO_ELEMENT);
        }
    }
}

