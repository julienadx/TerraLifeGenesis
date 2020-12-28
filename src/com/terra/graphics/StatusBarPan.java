package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class StatusBarPan extends JPanel {

    //graphics
    private JLabel[] data;
    private String[] dataName;
    private JLabel worldName;
    private JButton statButton;
    private GameButton restartButton;
    private GameButton pauseButton;


    StatusBarPan(String worldName, int scoreNbr, int moneyNbr) {
        super();
        this.setLayout(new GridLayout(1, 5));

        this.data = new JLabel[3];

        //money
        this.data[0] = new JLabel(Integer.toString(moneyNbr) + "$");

        //date
        this.data[1] = new JLabel("date: " + String.valueOf(0));

        //world
        this.worldName = new JLabel(worldName);

        //score
        this.data[2] = new JLabel("score: " + Integer.toString(moneyNbr));

        //buttons
        JPanel butPan = new JPanel();
        this.statButton = new JButton("stats");
        this.restartButton = new GameButton("RESTART", "restart");
        this.pauseButton = new GameButton("PAUSE", "pause");
        butPan.add(this.restartButton);
        butPan.add(this.pauseButton);
        butPan.add(this.statButton);

        this.add(this.data[0]);
        this.add(this.worldName);
        this.add(this.data[1]);
        this.add(this.data[2]);
        this.add(butPan);
    }

    public JButton getStatButton() {
        return statButton;
    }

    public GameButton getPauseButton() {
        return pauseButton;
    }

    public GameButton getRestartButton() {
        return restartButton;
    }

    public void modifyData(int index, int value) {
        String text = "";
        switch (index) {
            case 0:
                text = "$ ";
                break;
            case 1:
                text = "date :";
                break;
            case 2:
                text = "score: ";
                break;
        }
        this.data[index].setText(text + String.valueOf(value));

    }
}
