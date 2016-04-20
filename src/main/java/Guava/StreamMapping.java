package Guava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mareckip on 20.04.16.
 */
public class StreamMapping {
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1,"Woda");
        names.put(2, "Chmiel");
        List<Integer> order =  Arrays.asList(2, 3, 4);
        List<String> ans = names.entrySet()
                .stream()
                .filter(entry->order.contains(entry.getKey()))
                .map((Map.Entry::getValue))
                .collect(Collectors.toList());
    }
}
