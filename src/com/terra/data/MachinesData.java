package com.terra.data;

public enum MachinesData {
    PRICE(100),
    INCOME(2),
    PROB_STORM(8),
    PROB_METEOR(3),
    PROB_FIRE(7),
    PROB_DISEASE(4),
    MAX_LEVEL(20);

    private int value;

    MachinesData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
