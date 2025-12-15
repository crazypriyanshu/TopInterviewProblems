package org.pdas.maps;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Aman");
        Employee emp2 = new Employee(2, "Asha");
        Employee emp3 = new Employee(9, "Sandeep");
        Employee emp4= new Employee(4, "Triloki");
        Employee emp5= new Employee(4, "Chandar");


        HashMap<Integer, String> map = new HashMap<>();
        // when we ask JVM to create a map:
        // 1. JVM will create 16 buckets in heap memory
        // 2. If we keep on adding data and Hashmap object reaches 75% of its memory, then it doubles the capacity )=> meaning if 12 buckets are filled


        // 3. Buckets are nothing but the linked list
        // ***** Key must be an object and JVM will create the hashCode of this object , that's why we cant use primitive
        // hashcode/(size_of_total_buckets) -> will go to this bucket number

        // hash collision -> when jvm wants to put something in a bucket that bucket is already having that node
        // if the same key is present -> then jvm will update that key with new key value pair

        // if there are lots of hash collisions then the performance will degrade sharply, because lots of same hashcode will go to same bucket
        // hence when the size reaches to treeify_threshold then JVM converts the linked list to a tree and stores in a form of binary search tree or red-black tree or self balancing trees

        map.put(emp1.getId(), emp1.getName());
        map.put(emp2.getId(), emp2.getName());
        map.put(emp3.getId(), emp3.getName());
        map.put(emp4.getId(), emp4.getName());
        System.out.println(map);
        System.out.println(map.containsKey(9));
        // if we put the same key, it will update it with latest
        map.put(emp3.getId(), emp5.getName());
        System.out.println(map);
        // or you can replace with
        map.replace(2, "2Wala");
        System.out.println(map);
        // if key doesnt exists, it wont do anything to map
        map.replace(2222, "2Wala");
        System.out.println(map);
        map.putIfAbsent(22, "Mala");
        System.out.println(map);
        map.remove(2);
        System.out.println(map);

    }
}
