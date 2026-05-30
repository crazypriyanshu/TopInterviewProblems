package org.pdas.popularInterview.StreamCoolExamples;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Client {

    private static Map<Character, Long> countFrequencies(String input){
        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(
                    Function.identity(), Collectors.counting()
                ));
    }
    public record Employee(String name, String department, double salary) {}
    /**
     * You have a flat list of Employee objects, where each employee contains a name, department name, and a salary.
     * Write a stream pipeline that isolates the single highest-paid employee inside each department
     * */
    private static Map<String, Optional<Employee>> highestPaidEmployeeDepartmentWise(List<Employee> employees){
        return employees.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary))
                ));
    }


    public record ServerLog(String serverId, List<String> securityTags) {}
    /**
     * You are triaging a system incident.
     * You have a collection of ServerLog records.
     * Each log entry contains a list of tracking tags (Strings) representing security flags (e.g., ["AUTH_FAIL", "IP_BLOCKED"]).
     * Extract a unique, alphabetically sorted list of all security tags present across the entire cluster.
     * */
    public static List<String> extractSecurityTags(List<ServerLog> logs){
        return logs.stream()
                .filter(Objects::nonNull)
                .map(ServerLog::securityTags)
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .toList();
    }

    public static Optional<Character> findFirstNonRepeatingCharacter(String input){

            Map<Character, Long> ans = input.chars()
            .mapToObj(c -> (char) c)
            .collect(
                    Collectors.groupingBy(
                            Function.identity(),
                            LinkedHashMap::new,
                            Collectors.counting()
                    )
            );
            return ans.entrySet().stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst();
    }

    public static void main(String[] args) {

    }

    /**
     * You have a collection of e-commerce Order objects.
     * You need to generate a real-time nested dashboard report that groups orders by their Payment Status,
     * and within each status, groups the data by Currency,
     * and finally summarizes the total Revenue generated for that specific status-currency combination.
     *
     * */
    private Map<String, Map<String, BigDecimal>> generateRevenue(List<Order> orders){
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::paymentStatus, // level 1 grouping by paymentStatus
                        Collectors.groupingBy(
                                Order::currency, // level 2 grouping by currency
                                Collectors.mapping(
                                        Order::amount, // level 3 Map<amount, SumOfAllOrdersOfThatAmount>
                                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                                )
                        )
                ));
    }

    public record Product(String sku, boolean isOutOfStock) {}
    public record Category(String name, List<Product> products) {}
    public record Department(String name, List<Category> categories) {}

    /**
     * You are dealing with an event-driven catalog structure where
     * each Department contains a list of Category tracks,
     *  and each Category contains a list of individual Product inventory records.
     *  You need to extract a flat,
     *  unique set of all distinct Product objects across the entire enterprise directory
     *  that are currently marked out-of-stock,
     *  while handling potentially null intermediate collections defensively.
     * */
    private Set<Product> listOutOfStockProducts(List<Department> departments){
        return departments.stream()
                .map(Department::categories)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .map(Category::products)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    /**
     * You are reading millions of tracking IDs from a database,
     * and you need to push them to an external vendor API or a Kafka stream.
     * However, the external service limits requests to a maximum batch size of 3 records per payload call.
     * You need to chunk a continuous stream into small, fixed-size batches dynamically.
     * */


}
