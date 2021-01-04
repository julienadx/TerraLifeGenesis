package com.terra.data;

public enum LivingsData {

    BIOMASS(100);

    private int value;

    LivingsData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
