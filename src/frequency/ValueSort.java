package frequency;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Sorts by the value of the map
 */
public class ValueSort implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}