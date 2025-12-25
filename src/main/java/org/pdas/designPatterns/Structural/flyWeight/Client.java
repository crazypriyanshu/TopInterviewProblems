package org.pdas.designPatterns.Structural.flyWeight;

import com.github.javafaker.Faker;

public class Client {
    public static Faker faker = new Faker();

    public static String generateName(){
        return faker.name().firstName();
    }

    public static int generateInteger() {
        return faker.number().numberBetween(1, 10000);
    }
    private static final int BOOKS_TO_INSERT = 100000;
    private static final int FIXED_SIZE_DATA_COUNT = 3;
    public static void main(String[] args) {
        Store store = new Store();
        for (int i = 0; i < BOOKS_TO_INSERT; i++) {
            store.storeBooks(generateName(), generateInteger(), "Amazon.com", "FlatSaleDiscounted", "Sindbad Games");
        }
//        store.displayBook();
        System.out.println("Books inserted : "+BOOKS_TO_INSERT);
        System.out.println("---- memory usage ----");
        System.out.println("Book size(20 bytes) *  "+ BOOKS_TO_INSERT + " Book Type Size(30 bytes) * "+ FIXED_SIZE_DATA_COUNT+ " ");
        System.out.println("Total : "+((BOOKS_TO_INSERT*20 + FIXED_SIZE_DATA_COUNT*30) /1024 ) + " KB (instead of "+ (BOOKS_TO_INSERT*50)/1024+ " KB)");



    }
}
