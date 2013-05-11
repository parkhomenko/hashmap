package frequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Text files management util
 */
public class FileData {
    
    /**
     * Populates the HashMap object with data from the file
     * @param fileName the name of the file
     * @return created and filled Map
     */
    public static Map getData(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        
        File file = new File(fileName);
        
        try (BufferedReader bufferedReader =
                new BufferedReader(new FileReader(file))) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                
                //if the word have already been in the map,
                //increases the number of occurances,
                //otherwise sets this number to 1
                //and puts a new value to the map
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