/*
hash map
*/
import java.util.HashMap;
import java.util.Map;
class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap with String keys and Integer values
        HashMap<String, Integer> map = new HashMap<>();
        // 1. Adding elements
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("David", 40);
        System.out.println("HashMap: " + map);
        // 2. Getting a value by key
        System.out.println("Bob's age: " + map.get("Bob"));
        // 3. Checking if a key exists
        System.out.println("Contains key 'Charlie'? " + map.containsKey("Charlie"));
        // 4. Checking if a value exists
        System.out.println("Contains value 40? " + map.containsValue(40));
        // 5. Removing an element by key
        map.remove("David");
        System.out.println("After removing 'David': " + map);
        // 6. Checking size & if empty
        System.out.println("Size: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());
        // 7. Iterating over keys
        System.out.println("Iterating over keys:");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // 8. Iterating over values
        System.out.println("Iterating over values:");
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        // 9. Iterating over key-value pairs
        System.out.println("Iterating over key-value pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // 10. Replacing a value
        map.replace("Alice", 28);
        System.out.println("After replacing Alice's age: " + map);
        // 11. Clearing the map
        map.clear();
        System.out.println("After clear, size: " + map.size());
        // ------------------ Integer HashMap ------------------
        HashMap<Integer, String> numMap = new HashMap<>();
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        System.out.println("Integer HashMap: " + numMap);
    }
}
