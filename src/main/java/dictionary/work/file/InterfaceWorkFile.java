package dictionary.work.file;

/**
 * Интерфейс определяет методы для чтения-записи файла
 */
public interface InterfaceWorkFile {
    /**
     * Метод чтения файла в map
     *
     * @param numberOfDictionary аргумент - номер словаря по которому будет выбран читаемый файл
     */
    void read(int numberOfDictionary);
    /**
     * Метод записи файла из map
     *
     * @param numberOfDictionary аргумент - номер словаря, по которому будет выбран файл, который будет считан с map и записан на диск
     */
    void write(int numberOfDictionary);
}
