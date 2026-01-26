package org.pdas.LLD.TrafficManagement.phase;

import java.util.List;

public class TrafficPhase {
    private final List<Integer> roadNumbers;

    public TrafficPhase(List<Integer> roadNumbers) {
        this.roadNumbers = roadNumbers;
    }

    public List<Integer> getRoadNumbers() {
        return roadNumbers;
    }
}
