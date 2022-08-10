package dictionary.work.file;

import dictionary.work.exeption.FileException;

import java.io.IOException;

/**
 * Интерфейс определяет методы для чтения-записи файла
 */
public interface InterfaceWorkFile {
    /**
     * Метод чтения файла в map
     *
     * @param numberOfDictionary аргумент - номер словаря по которому будет выбран читаемый файл
     * @throws FileException If an I/O error occurs(IOException)
     *                       if the regular expression's syntax is invalid(PatternSyntaxException)
     *                       if the put operation is not supported by this map(UnsupportedOperationException)
     *                       if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    void read(int numberOfDictionary);

//    /**
//     * Метод записи файла из map
//     *
//     * @param numberOfDictionary аргумент - номер словаря, по которому будет выбран файл, который будет считан с map и записан на диск
//     * @throws FileException If an I/O error occurs(IOException)
//     */
//    void write(int numberOfDictionary);
}
