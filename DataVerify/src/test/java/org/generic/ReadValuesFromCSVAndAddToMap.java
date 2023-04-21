package org.generic;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadValuesFromCSVAndAddToMap {
    public static List<Map<String, String>> data = new ArrayList<>();
    public static List<Map<String, String>> data2 = new ArrayList<>();
    public static List<Map<String, String>> data3 = new ArrayList<>();
   static CSVReader reader ;
    public static List<Map<String, String>> readDataFromDataCSV(String filename){
        try {
            reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/"+filename+".csv"));

            // get the header columns
            String[] header = reader.readNext();

            // read each row and add to list of maps
            String[] line;
            while ((line = reader.readNext()) != null) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    map.put(header[i], line[i]);
                }
                data.add(map);
            }
            // close the reader
            //reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public static List<Map<String, String>> readDataFromPositionCSV(String filename){
        try {
            reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/"+filename+".csv"));

            // get the header columns
            String[] header = reader.readNext();

            // read each row and add to list of maps
            String[] line;
            while ((line = reader.readNext()) != null) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    map.put(header[i], line[i]);
                }
                data2.add(map);
            }
            // close the reader
            //reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return data2;
    }
    public static List<Map<String, String>> readDataFromOutputCSV(String filename){
        try {
            reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/"+filename+".csv"));

            // get the header columns
            String[] header = reader.readNext();

            // read each row and add to list of maps
            String[] line;
            while ((line = reader.readNext()) != null) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    map.put(header[i], line[i]);
                }
                data3.add(map);
            }
            // close the reader
            //reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return data3;
    }
}
