package org.pdas.designPatterns.prototype.ShapesExample;

public class PrototypePatterDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape1 = ShapeCache.getShape("1");
        System.out.println("Shape" + clonedShape1.getName());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape "+ clonedShape2.getName());
    }
}
