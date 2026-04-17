package org.pdas.streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeranStream {
    /**
     * <h3>Common Stream Patterns</h3>
     *
     * <p>Collection and Transformation</p>
     * <ul>
     *     <li>Accumulate names into a List</li>
     *            {@code List<String> list = people. stream()
     *                      .map(Person::getName)
     *                      .collect(Collectors. toList());}
     *
     * </ul>
     *
     *
     * Accumulate names into a TreeSet
     *      Set<String> set = people. stream()
     *              .map(Person::getName)
     *              .collect(Collectors. toCollection(TreeSet::new));
     *
     * Convert elements to strings and concatenate them, separated by commas
     *      String joined = things. stream()
     *              .map(Object::toString)
     *              .collect(Collectors. joining(", "));
     *
     * Compute sum of salaries of employee
     *      int total = employees. stream()
     *              .collect(Collectors. summingInt(Employee::getSalary));
     *
     * Group employees by department
     *      Map<Department, List<Employee>> byDept = employees. stream()
     *              .collect(Collectors. groupingBy(Employee::getDepartment));
     *
     * Compute sum of salaries by department
     *      ```Map<Department, Integer> totalByDept = employees. stream()
     *              .collect(Collectors. groupingBy(Employee::getDepartment,
     *                      Collectors. summingInt(Employee::getSalary)));  ```
     *
     * Partition students into passing and failing
     *      Map<Boolean, List<Student>> passingFailing = students. stream()
     *              .collect(Collectors. partitioningBy(s -> s. getGrade() >= PASS_THRESHOLD));
     * */
    public static void main(String[] args) {
        // doSomething();
        doSomethingElse();


    }

     static void doSomething(){
        String[] words= {"Alpha", "Beta", "Gama", "Theta", "Epsilon", "Degree"};
        Map<Integer, Long> ans = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        ans.forEach((len, count) -> {
            System.out.println("for Length: "+ len+" count is: "+count);
        });

        ans.forEach(LeranStream::logData);
    }

    public record Sale(int id, int price, String product, LocalDateTime time){};

    private static void doSomethingElse(){
        Sale sale = new Sale(1, 100, "Toothbrush",LocalDateTime.now());
        Sale sale1 = new Sale(1, 10, "Abc",LocalDateTime.now());
        Sale sale2 = new Sale(1, 10, "ced",LocalDateTime.now());
        Sale sale3 = new Sale(1, 130, "stamp",LocalDateTime.now());
        Sale sale4 = new Sale(1, 130, "steam",LocalDateTime.now());
        Sale sale5 = new Sale(1, 03, "rook",LocalDateTime.now());

        List<Sale> sales = List.of(sale1, sale2, sale3, sale4, sale5, sale);
        var sal = sales.stream()
                .collect(Collectors.groupingBy(Sale::price, Collectors.toList()));
        System.out.println();


    }
    private static void logData(int num, long count ){
        System.out.printf("Key: %d, Value: %d%n", num, count);
    }
}
