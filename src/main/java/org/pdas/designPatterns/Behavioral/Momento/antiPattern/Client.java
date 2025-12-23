package org.pdas.designPatterns.Behavioral.Momento.antiPattern;

public class Client {
    public static void main(String[] args) {
        DocumentHistoryManager manager = new DocumentHistoryManager();

        Document document = new Document("This");
        manager.save(document);
        Document document1 = new Document(" This \n is ");
        manager.save(document1);
        Document document2 = new Document(" This is a valid \n case and we would see");
        manager.save(document2);
    }
}
