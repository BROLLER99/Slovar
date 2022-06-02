package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WorkFile {
    Dictionary dictionary = new Dictionary();

    public void read(String nameFile) {

        File file = new File(nameFile);
        if (!file.exists()) {
            write(nameFile);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line = null;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(":");

                String name = parts[0].trim();
                String value = parts[1].trim();

                if (!name.equals("") && !value.equals(""))
                    dictionary.getDictionary().put(name, value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(String nameFile) {
        File file = new File(nameFile);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {

            for (Map.Entry<String, String> entry : dictionary.getDictionary().entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
