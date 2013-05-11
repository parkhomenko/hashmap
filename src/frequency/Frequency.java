package frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Main program for thesting HashMap and Collections' functions
 */
public class Frequency {

    /**
     * The entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        
        //Gets the name of the file and fills the map with the data from that file
        System.out.print("Enter name of file of words: ");
        Map<String, Integer> map = FileData.getData(getFileName());
        if (map == null) {
            System.exit(0);
        }
        
        //Shows the current state of the map
        System.out.println();
        System.out.println("Map:");
        System.out.println(map);
        
        //Fills the ArrayList with the entries of the HashMap
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        
        //Sorts the ArrayList by key of the Map entry
        KeySort keySort = new KeySort();
        Collections.sort(list, keySort);
        
        //Shows the current state of the map
        System.out.println();
        System.out.println("List (sorted alphabetically):");
        System.out.println(list);
        
        //Sorts the ArrayList by value of the Map entry
        ValueSort valueSort = new ValueSort();
        Collections.sort(list, valueSort);
        
        //Shows the current state of the map
        System.out.println();
        System.out.println("List (sorted by frequency):");
        System.out.println(list);
    }
    
    /**
     * Reads the name of the file from the console
     * @return the name of the file
     */
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