package myUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MyUtilities {
    public static List<String[]> readData(String filePath) throws FileNotFoundException {
        List<String[]> data = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        try {
            String row;
            while((row = reader.readLine()) != null){
                String[] rowRecords = row.split(",");
                data.add(rowRecords);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
    //for commit changes
}
