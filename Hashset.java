/* HashSet example */
import java.util.HashSet;
import java.util.Iterator;
public class Hashset{
    public static void main(String[] args) {
        // Creating a HashSet of Strings
        HashSet<String> names = new HashSet<>();
        // 1. Adding elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Alice"); // Duplicate (ignored)
        System.out.println("HashSet: " + names);
        // 2. Checking size & if empty
        System.out.println("Size: " + names.size());
        System.out.println("Is empty? " + names.isEmpty());
        // 3. Checking if an element exists
        System.out.println("Contains 'Charlie'? " + names.contains("Charlie"));
        // 4. Removing an element
        names.remove("David");
        System.out.println("After removing 'David': " + names);
        // 5. Iterating using for-each loop
        System.out.println("Iterating using for-each loop:");
        for (String name : names) {
            System.out.println(name);
        }
        // 6. Iterating using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 7. Converting to an array
        String[] namesArray = names.toArray(new String[0]);
        System.out.println("Array version: " + String.join(", ", namesArray));
        // 8. Clearing all elements
        names.clear();
        System.out.println("After clear, size: " + names.size());
        // ------------------ Integer HashSet ------------------
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(30);
        numbers.add(20);
        System.out.println("Integer HashSet: " + numbers);
        // Removing an element
        numbers.remove(10);
        // Checking if it contains a value
        System.out.println("Contains 20? " + numbers.contains(20));
        // Printing numbers
        System.out.println("Numbers list:");
        numbers.forEach(System.out::println);
    }
}
