import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) {
        // Step 2: Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Bob", 30, "Los Angeles"));
        people.add(new Person("Charlie", 22, "New York"));
        people.add(new Person("Diana", 28, "Chicago"));
        people.add(new Person("Eve", 35, "New York"));

        // Step 3: Sort the list by age using lambda and Comparator
        people.sort(Comparator.comparingInt(person -> person.age));

        // Print the sorted list
        System.out.println("Sorted by age:");
        people.forEach(System.out::println);

        // Step 4: Filter the list to include only people from "New York"
        people.removeIf(person -> !person.city.equals("New York"));

        // Print the filtered list
        System.out.println("\nFiltered by city (New York):");
        people.forEach(System.out::println);
    }
}
