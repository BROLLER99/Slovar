package dictionary.work.file;

import dictionary.work.exeption.FileException;
import dictionary.work.map.InterfaceDictionary;

import java.io.*;

/**
 * Класс реализует методы интерфейса InterfaceDictionary
 */
public class WorkFile implements InterfaceDictionary {
    private static final String WORDS_FILE = "words.txt";
    private static final String NUMBERS_FILE = "chisla.txt";
    private static final int ONE_FOR_NUMBER_OF_DICTIONARY = 1;
    private static final int ONE_FOR_SPLIT = 1;
    private static final int ZERO_FOR_SPLIT = 0;
    private static final String KEY_VALUE_SEPARATOR = ":";
    private int numberOfDictionary;
    private String nameFile;

    @Override
    public void addElement(String key, String value) {
        if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
            nameFile = WORDS_FILE;
        } else nameFile = NUMBERS_FILE;
        try {
            File file = new File(nameFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            fw.write(key + KEY_VALUE_SEPARATOR + value + "\n");
            fw.close();
        } catch (IOException e) {
            throw new FileException("Ошибка записи файла");
        }
    }

    public void getDictionary(int numberOfDictionary) {
        this.numberOfDictionary = numberOfDictionary;
    }

    @Override
    public StringBuilder outputAllElements() {
        if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
            nameFile = WORDS_FILE;
        } else nameFile = NUMBERS_FILE;
        File file = new File(nameFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();
                String value = parts[ONE_FOR_SPLIT].trim();

                if (!name.equals("") && !value.equals(""))
                    stringBuilder.append(name).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
            }
            return stringBuilder;
        } catch (IllegalArgumentException | NullPointerException | ClassCastException | UnsupportedOperationException |
                 IOException e) {
            throw new FileException("Ошибка чтения файла");
        }
    }

    @Override
    public boolean searchElement(String key) {
        if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
            nameFile = WORDS_FILE;
        } else {
            nameFile = NUMBERS_FILE;
        }
        File file = new File(nameFile);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();

                if (name.equals(key)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new FileException("Ошибка чтения файла");
        }
    }

    @Override
    public void deleteElement(String key) {
        if (numberOfDictionary == ONE_FOR_NUMBER_OF_DICTIONARY) {
            nameFile = WORDS_FILE;
        } else {
            nameFile = NUMBERS_FILE;
        }
        File file = new File(nameFile);
        File tmpFile = new File("tmp" + nameFile);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(KEY_VALUE_SEPARATOR);

                String name = parts[ZERO_FOR_SPLIT].trim();

                if (!name.equals(key)) {
                    bw.write(line);
                    bw.newLine();
                }

            }
            bw.close();
            br.close();
            file.delete();
            tmpFile.renameTo(file);

        } catch (NullPointerException | SecurityException | IOException e) {
            throw new FileException("Ошибка файла");
        }
    }
}
