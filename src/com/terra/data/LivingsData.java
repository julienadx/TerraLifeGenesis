package com.terra.data;

public enum LivingsData {

    BIOMASS(2),
    LEVEL_MAX (4);

    private int value;

    LivingsData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
