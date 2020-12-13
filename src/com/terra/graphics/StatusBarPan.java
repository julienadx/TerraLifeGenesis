package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class StatusBarPan extends JPanel {

    //graphics
    private JLabel score;
    private JLabel money;
    private JLabel worldName;
    private JButton statButton;

    //data
    private int scoreNbr;
    private int moneyNbr;

    StatusBarPan(String worldName, int scoreNbr, int moneyNbr) {
        super();
        this.setLayout(new GridLayout(1, 4));

        //money
        this.moneyNbr = moneyNbr;
        this.money = new JLabel(Integer.toString(this.moneyNbr) + "$");

        //world
        this.worldName = new JLabel(worldName);

        //score
        this.scoreNbr = scoreNbr;
        this.score = new JLabel("score: " + Integer.toString(this.moneyNbr));

        //button
        this.statButton = new JButton("stats");

        this.add(this.money);
        this.add(this.worldName);
        this.add(this.score);
        this.add(this.statButton);
    }

    public JButton getStatButton() {
        return statButton;
    }
}
