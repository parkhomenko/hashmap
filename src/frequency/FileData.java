package frequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileData {
    
    public static Map getData(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        
        File file = new File(fileName);
        
        try (BufferedReader bufferedReader =
                new BufferedReader(new FileReader(file))) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                String[] words = line.split(" ");
                for (String word : words) {
                    Integer value = map.get(word);
                    if (value == null) {
                        value = 1;
                    } else {
                        value++;
                    }
                    map.put(word, value);
                }
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return map;
    }
}