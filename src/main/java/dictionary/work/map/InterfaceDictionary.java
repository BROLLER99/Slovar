package dictionary.work.map;

import dictionary.work.exeption.FileException;

import java.util.Map;

/**
 * Интерфейс определяет методы для работы с словарем
 */
public interface InterfaceDictionary {
    /**
     * Метод добавление элемента
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     * @throws FileException if the put operation is not supported by this map(UnsupportedOperationException)
     *                       if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    void addElement(String key, String value);

    /**
     * Метод вывода элемента
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо вывести
     * @throws FileException if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
//    String outputElement(String key);
//
//    /**
//     * Метод удаления элемента
//     *
//     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
//     * @throws FileException if the put operation is not supported by this map(UnsupportedOperationException)
//     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
//     *                       if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
//     */
//    void deleteElement(String key);
//
    /**
     * Метод поиска элемента
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     * @throws FileException if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    boolean searchElement(String key);

    /**
     * Метод для вывода всех элементов
     *
     * @throws FileException if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    StringBuilder outputAllElements();
}