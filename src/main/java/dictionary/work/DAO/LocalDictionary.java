package dictionary.work.DAO;

import dictionary.work.exeption.FileException;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Класс реализует методы интерфейса InterfaceDictionary по работе с файлом
 */
public class LocalDictionary implements Dictionary {
    private static final String ADD_EXCEPTION = "Ошибка добавления элемента";
    private static final String DELETE_EXCEPTION = "Ошибка удаления элемента";
    private static final String SEARCH_EXCEPTION = "Ошибка поиска элемента";
    private static final String OUTPUT_ALL_EXCEPTION = "Ошибка вывода всех элементов";
    private static final String WORDS_FILE = "words.txt";
    private static final String NUMBERS_FILE = "chisla.txt";
    private static final String TMP_FILE="tmp";
    private static final int ONE_FOR_NUMBER_OF_DICTIONARY = 1;
    private static final int ONE_FOR_SPLIT = 1;
    private static final int ZERO_FOR_SPLIT = 0;
    private static final String KEY_VALUE_SEPARATOR = ":";
    private static int numberOfDictionary;
    private String nameFile;

    /**
     * Реализация метода добавления записи в файл, интерфейса InterfaceDictionary
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     * @throws FileException If a security manager exists and method denies write access to the file (SecurityException)
     *                       If an I/O error occurs(IOException)
     */
    @Override
    public void addElement(String key, String value) {
        nameOfFile(numberOfDictionary);
        try {
            File file = new File(nameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(key + KEY_VALUE_SEPARATOR + value + "\n");
            fileWriter.close();
        } catch (SecurityException | IOException e) {
            throw new FileException(ADD_EXCEPTION);
        }
    }

    /**
     * Метод получения номера словаря выбранного пользователем
     *
     * @param numberOfDictionary - номер словаря
     */
    public void setNumberOfDictionary(int numberOfDictionary) {
        this.numberOfDictionary = numberOfDictionary;
    }

    /**
     * Реализация метода вывода всех записей из файла, интерфейса InterfaceDictionary
     *
     * @return возвращает строку в которой содержаться все элементы
     * @throws FileException If an I/O error occurs(IOException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public StringBuilder outputAllElements() {
        nameOfFile(numberOfDictionary);
        File file = new File(nameFile);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();
                String value = parts[ONE_FOR_SPLIT].trim();

                if (!name.equals("") && !value.equals(""))
                    stringBuilder.append(name).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
            }
            return stringBuilder;
        } catch (NullPointerException | IOException e) {
            throw new FileException(OUTPUT_ALL_EXCEPTION);
        }
    }

    /**
     * Реализация метода поиска записи в файле, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     * @return true если элемент найден и false если нет
     * @throws FileException If an I/O error occurs(IOException)
     */
    @Override
    public boolean searchElement(String key) {
        nameOfFile(numberOfDictionary);
        File file = new File(nameFile);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();

                if (name.equals(key)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new FileException(SEARCH_EXCEPTION);
        }
    }

    /**
     * Реализация метода удаления записи в файле, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     * @throws FileException If an I/O error occurs(IOException)
     *                       if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                       If a security manager exists and method denies write access to the file (SecurityException)
     */
    @Override
    public void deleteElement(String key) {
        nameOfFile(numberOfDictionary);
        File file = new File(nameFile);
        File tmpFile = new File(TMP_FILE + nameFile);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();

                if (!name.equals(key)) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

            }
            bufferedWriter.close();
            bufferedReader.close();
            file.delete();
            tmpFile.renameTo(file);

        } catch (NullPointerException | SecurityException | IOException e) {
            throw new FileException(DELETE_EXCEPTION);
        }
    }

    /**
     * Метод определения имени файла словаря по номеру словаря
     *
     * @param numberOfDictionary - номер словаря
     * @return возвращает имя файла
     */
    private String nameOfFile(int numberOfDictionary) {
        if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
            return nameFile = WORDS_FILE;
        } else return nameFile = NUMBERS_FILE;
    }
}
