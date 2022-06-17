package dictionary.work.map;

import java.util.Map;
/**
 * Интерфейс определяет методы для работы с Map
 */
public interface InterfaceDictionary {
    /**
     * Метод добавление элемента в Map
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     */
    void addElement(String key, String value);
    /**
     * Метод вывода элемента из Map
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо вывести
     */
    String outputElement(String key);
    /**
     * Метод удаления элемента из Map
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     */
    void deleteElement(String key);
    /**
     * Метод поиска элемента в Map
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     */
    boolean searchElement(String key);
    /**
     * Метод для вывода всех элементов из Map
     */
    StringBuilder outputAllElements();
    /**
     * Метод получения содержимого Map
     */
    Map<String, String> getDictionary();
}