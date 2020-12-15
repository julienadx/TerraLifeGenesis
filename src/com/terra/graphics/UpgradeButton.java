package com.terra.graphics;

import javax.swing.*;

public class UpgradeButton extends JButton {

    private int index;

    UpgradeButton(int index, String text) {
        super(text);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
