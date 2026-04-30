package org.pdas.arrays.mostAskedProblems.elevator;

public abstract class Button {
    private int id;
    private String display;
        private boolean status;
    public Button(int id, String floor){
        this.id = id;
        calculateDisplay(id);
        this.status = false; // button is initiated in Off condition
    }

    private void calculateDisplay(int id){
        if (id < 0){
            this.display = "Basement-"+id;
        } else if (id == 0) {
            this.display = "Ground";
        } else {
            this.display = "Floor"+id;
        }
    }

    public abstract void onPress();
}
