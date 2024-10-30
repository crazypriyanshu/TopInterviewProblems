package org.pdas.designPatterns.prototype;

import lombok.Data;

@Data
public class Circle implements Shape{
    private String color;
    public Circle(String color){
        this.color = color;
    }
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    @Override
    public void draw() {

        System.out.println("Drawing a circle ");
    }
}
