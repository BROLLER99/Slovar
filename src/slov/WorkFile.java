package slov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WorkFile {
    Slov slov = new Slov();
    public void read(String a) {

        BufferedReader br = null;
        try {
            //create file object
            File file = new File(a);
            if(!file.exists()){
                write(a);
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
                    slov.getSlovar().put(name, value);
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
    public void write(String a){
        File file = new File(a);
        BufferedWriter bf = null;;
        try{
            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
            //iterate map entries
            for(Map.Entry<String, String> entry : slov.getSlovar().entrySet()){
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
