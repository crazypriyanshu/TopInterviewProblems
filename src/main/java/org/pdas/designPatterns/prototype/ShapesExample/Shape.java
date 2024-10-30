package org.pdas.designPatterns.prototype.ShapesExample;

abstract class Shape implements Cloneable{
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    abstract void draw();

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
        return clone;
    }

}
