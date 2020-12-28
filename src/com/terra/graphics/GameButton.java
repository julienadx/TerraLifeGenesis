package com.terra.graphics;

import javax.swing.*;

public class GameButton extends JButton {

    private String context;
    private int index;

    GameButton(String context, String text) {
        super(text);
        this.context = context;
    }

    GameButton(String context) {
        this(context, "");
    }

    public String getContext() {
        return context;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
