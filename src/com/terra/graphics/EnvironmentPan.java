package com.terra.graphics;

import javax.swing.*;

//TODO to work here
public class EnvironmentPan extends Pan{

    private final static String[] itemList = {"oxygen: ", "temperature: ", "water: ", "minerals: ", "gravity: ", "day cycle: "};
    private int[] valueItemList;

    EnvironmentPan() {
        super("ENVIRONMENT", 2);
        this.valueItemList = new int[6];
        this.add(new JLabel(generateStringValues()));
    }

    private String generateStringValues() {
        String values = "";
        for (int i=0; i<itemList.length; i++) {
            values += itemList[i] + valueItemList[i] + "\n";
        }
        return values;
    }

    public int[] getValueItemList() {
        return valueItemList;
    }

    public void setValueItemList(int[] valueItemList) {
        this.valueItemList = valueItemList;
    }

    public void setValueItemIndex(int valueItem, int index) {
        this.valueItemList[index] = valueItem;
    }
}
