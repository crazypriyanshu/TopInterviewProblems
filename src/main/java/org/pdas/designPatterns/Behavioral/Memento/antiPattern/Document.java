package org.pdas.designPatterns.Behavioral.Memento.antiPattern;

// The Originator

public class Document {
    /*
    * The contents of this class is public - violating encapsulation
    * */
    public String content;
    public int x_coordinate;
    public int y_coordinate;

    public Document(String content){
        this.content = content;
        this.x_coordinate = 0;
        this.y_coordinate = 0;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getX_coordinate() {
        return content.length();
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        int count = calculateNewLines(content, y_coordinate);
        return y_coordinate;
    }

    private int calculateNewLines(String content, int y_coordinate){
        if (content == null) return y_coordinate;
//        for (int i = 0; i < content.length(); i++) {
//            if (content.charAt(i) == '\n'){
//                y_coordinate++;
//            }
//        }

        long line_count = content.chars().filter(ch -> ch == '\n').count();
        return y_coordinate + (int) line_count;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
}
