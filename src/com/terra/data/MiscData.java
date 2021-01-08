package com.terra.data;

public enum MiscData {

    TIME_DAY (700);

    private int value;

    MiscData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
