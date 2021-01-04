package com.terra.data;

public enum PlayerData {

    DOLLARS (500);

    private int value;

    PlayerData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
