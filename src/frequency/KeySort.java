package frequency;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Sorts by the key of the map
 */
public class KeySort implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        return o1.getKey().compareTo(o2.getKey());
    }
}