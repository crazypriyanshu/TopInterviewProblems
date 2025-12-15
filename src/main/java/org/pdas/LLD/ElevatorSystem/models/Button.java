package org.pdas.LLD.ElevatorSystem.models;

public abstract class Button {
    private boolean isPressed = false;

    public abstract boolean isPressed();

    public abstract boolean press();
}
