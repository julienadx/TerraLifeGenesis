package com.terra.data;

public enum MachinesData {
    PRICE(100),
    INCOME(4),
    PROB(30),
    MAX_LEVEL(10);

    private int value;

    MachinesData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
