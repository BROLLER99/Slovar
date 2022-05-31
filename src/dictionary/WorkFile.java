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

        BufferedReader br = null;
        try {
            //create file object
            File file = new File(nameFile);
            if(!file.exists()){
                write(nameFile);
            }
            //create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            //read file line by line
            while ((line = br.readLine()) != null) {

                //split the line by :
                String[] parts = line.split(":");

                //first part is key, second is value
                String name = parts[0].trim();
                String value = parts[1].trim();

                //put key, value in HashMap if they are not empty
                if (!name.equals("") && !value.equals(""))
                    dictionary.getDictionary().put(name, value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //Close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {}
            }
        }
    }
    public void write(String nameFile){
        File file = new File(nameFile);
        BufferedWriter bf = null;;
        try{
            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
            //iterate map entries
            for(Map.Entry<String, String> entry : dictionary.getDictionary().entrySet()){
                //put key and value separated by a colon
                bf.write( entry.getKey() + ":" + entry.getValue() );
                //new line
                bf.newLine();
            }
            bf.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                //always close the writer
                bf.close();
            }catch(Exception e){}
        }
    }
}
