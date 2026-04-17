package org.pdas.arrays.mostAskedProblems;

import java.lang.reflect.Field;
import java.util.HashMap;

public class HashMapCollisonDemo {
    public static class BadKey{
        private final int id;
        BadKey(int id){
            this.id = id;
        }

        @Override
        public int hashCode() {
            return 12344;
        }

        @Override
        public boolean equals(Object object){
            if (this == object) return true;
            if (!(object instanceof BadKey)){
                return false;
            }
            return id == ((BadKey) object).id;
        }

        @Override
        public String toString(){
            return "Key-> "+id;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        HashMap<BadKey, String> map = new HashMap<>();
        for (int i = 0; i < 1200; i++) {
            map.put(new BadKey(i), "val "+i);
            printMapStructure(map);
            System.out.println();
            System.out.println("----------------------");
            System.out.println();
        }
        System.gc();
    }

    private static void printMapStructure(HashMap<?, ?> map) throws NoSuchFieldException, IllegalAccessException {
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);
        if (table == null){
            System.out.println("Map is not yet initialized");
            return;
        }


        // FIND THE BUCKET WHICH HOLDS KEY
        int hash = 12344;
        int n = table.length;
        int index = (n-1)& hash;
        Object node = table[index];
        if (node == null){
            System.out.println("Table is empty");
        }

        // check bucket is a tree node(R-B Tree) or a plain node (SLL- Singly Linked List)
        String nodeClassName = node.getClass().getSimpleName();
        System.out.println("node class name is: "+nodeClassName);
        boolean isTree = nodeClassName.contains("TreeNode");
        System.out.println("BucketIndex = "+ index+ " contains: "+ nodeClassName);
        if (isTree){
            System.out.println(" >>> Treeified! collisions > 0");
        } else {
            int count = countLLNode(node);
            System.out.println(" >> LL : length is: "+count);
        }
    }

    private static int countLLNode(Object node) throws NoSuchFieldException, IllegalAccessException {
        int count = 0;
        Field nextField = node.getClass().getDeclaredField("next");
        nextField.setAccessible(true);
        while (node != null){
            count++;
            node = nextField.get(node);
        }
        return count;
    }


}
