package dictionary.work.map;

/**
 * Интерфейс определяет методы для работы со словарем
 */
public interface InterfaceDictionary {
    /**
     * Метод добавление элемента
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     */
    void addElement(String key, String value);


    /**
     * Метод удаления элемента
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    void deleteElement(String key);

    /**
     * Метод поиска элемента
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     */
    boolean searchElement(String key);

    /**
     * Метод для вывода всех элементов
     */
    StringBuilder outputAllElements();
}