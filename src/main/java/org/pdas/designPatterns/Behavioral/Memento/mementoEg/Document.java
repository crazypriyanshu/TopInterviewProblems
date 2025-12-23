package org.pdas.designPatterns.Behavioral.Memento.mementoEg;
// Originator class
public class Document {
    private String content;
    private int x_coordinate;
    private int y_coordinate;

    public Document(String content){
        this.content = content;
        this.x_coordinate = content.length();
        this.y_coordinate = findNewLines(content);
        System.out.println("Initialized new Originator");
    }

    private int findNewLines(String content){
        return (int) content.chars().filter(ch -> ch == '\n').count();
    }

    //
    public Memento save(){
        // create new Memento ( The "Wide" interface is only visible here)
        return new Memento(content, x_coordinate, y_coordinate);
    }

    public void restore(Memento memento) {
        this.content = memento.content;
        this.x_coordinate = memento.x_coordinate;
        this.y_coordinate = memento.y_coordinate;
    }


    public void setContent(String content){
        this.content = content;
    }



    // Memento - private inner class not visible to outside world
    public static class Memento{
        // immutable
        private final String content;
        private final int x_coordinate;
        private final int y_coordinate;

        // private constructor
        private Memento(String content, int x_coordinate, int y_coordinate){
            this.content = content;
            this.x_coordinate = x_coordinate;
            this.y_coordinate = y_coordinate;
            System.out.println("Initialized the Memento Object");
        }

        @Override
        public String toString() {
            return "Memento{" +
                    "content='" + content + '\'' +
                    ", x_coordinate=" + x_coordinate +
                    ", y_coordinate=" + y_coordinate +
                    '}';
        }

        // no setters as this is immutable class

    }
}
