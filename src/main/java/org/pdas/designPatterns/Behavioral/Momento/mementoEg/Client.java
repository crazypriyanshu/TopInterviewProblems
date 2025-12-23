package org.pdas.designPatterns.Behavioral.Momento.mementoEg;

import javax.print.Doc;

public class Client {
    public static void main(String[] args) {

        Document document =new Document("This is us");
        Document document1 = new Document("This is just fun");
        Document document2 = new Document("This is \n and not \n gov");
        document.save();
        DocumentHistoryManager manager = new DocumentHistoryManager();
        manager.write(document.save());
        manager.write(document1.save());

        manager.write(document2.save());
        manager.unDo();


    }

}
