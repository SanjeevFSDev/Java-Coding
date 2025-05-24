package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSortExample {
	
	public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(101, "Rahul");
        map1.put(103, "Raj");
        map1.put(106, "Chinna");
        map1.put(105, "Rahim");

        Map<String, Double> map2 = new HashMap<>();
        map2.put("Chinna", 50000.0);
        map2.put("Rahim", 60000.0);
        map2.put("Raj", 70000.0);
        map2.put("Rahul", 20000.0);

        // Step 1: Sort map2 by value in descending order
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(map2.entrySet());
        sortedList.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        System.out.println(sortedList);
        
        // Step 2: Reverse lookup in map1 and print the result
        for (Map.Entry<String, Double> entry : sortedList) {
            String name = entry.getKey();
            Double salary = entry.getValue();

            // Find the corresponding key from map1
            Integer id = map1.entrySet()
                    .stream()
                    .filter(e -> e.getValue().equals(name))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);  // Optional: handle null if name not found

            if (id != null) {
                System.out.println(id + "," + salary);
            }
        }
    }
}
