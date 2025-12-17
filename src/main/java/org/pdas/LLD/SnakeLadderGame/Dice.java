package org.pdas.LLD.SnakeLadderGame;

import java.util.Random;

public class Dice {
    private int minValue;
    private int maxValue;

    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int roll(){
        return (int) (Math.random() * (maxValue - minValue +1) + minValue);
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
