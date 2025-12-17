import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = readFile().stream()
                .filter(e -> !e.isBlank())
                .map(str -> {
                    String[] arr = str.trim().split(" ");
                    return new Employee(arr[0], arr[1]);
                }).toList();

        System.out.println("Size of collection: " + employees.size());

        System.out.println("\nPrint employees data in alphabetical order:");
        employees.forEach(System.out::println);
    }

    private static TreeSet<String> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/employees.txt"))) {
            var list = br.lines().toList();
            TreeSet<String> ts = new TreeSet<>(list);
            System.out.println("Size of TreeSet: " + ts.size());
            return ts;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file.");
        }
    }
}