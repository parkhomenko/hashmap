package frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Frequency {

    public static void main(String[] args) {
        
        System.out.print("Enter name of file of words: ");
        Map<String, Integer> map = FileData.getData(getFileName());
        if (map == null) {
            System.exit(0);
        }
        
        System.out.println();
        System.out.println("Map:");
        System.out.println(map);
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        
        KeySort keySort = new KeySort();
        Collections.sort(list, keySort);
        
        System.out.println();
        System.out.println("List (sorted alphabetically):");
        System.out.println(list);
        
        ValueSort valueSort = new ValueSort();
        Collections.sort(list, valueSort);
        
        System.out.println();
        System.out.println("List (sorted by frequency):");
        System.out.println(list);
    }
    
    private static String getFileName() {
        String fileName = "";
        
        try (Scanner scanner = new Scanner(System.in)) {
            fileName = scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        return fileName;
    }
}