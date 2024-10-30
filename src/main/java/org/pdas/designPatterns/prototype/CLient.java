package org.pdas.designPatterns.prototype;

public class CLient {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Aman", "Singh", "aman@abc.com");


        Shape circlePrototype = new Circle("red");
        ShapeClient shapeClient = new ShapeClient(circlePrototype);
        Shape redCircle = shapeClient.createShape();
        redCircle.draw();
        Shape blueCircle = redCircle.clone();


    }
}
