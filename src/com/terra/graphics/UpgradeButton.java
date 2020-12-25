package com.terra.graphics;

import javax.swing.*;

public class UpgradeButton extends JButton {

    private int index;
    private String context;

    UpgradeButton(int index, String text, String context) {
        super(text);
        this.index = index;
        this.context = context;
    }

    UpgradeButton(UpgradeButton button) {
        this(button.getIndex(), button.toString(), button.getContext());
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
}
