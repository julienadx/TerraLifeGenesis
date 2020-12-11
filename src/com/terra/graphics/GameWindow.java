package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        this.setTitle("Terra Life Genesis v0.1");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        this.setLayout(new GridLayout(2, 2));
        this.getContentPane().add(new JLabel("1"));
        this.getContentPane().add(new JLabel("2"));
        this.getContentPane().add(new JLabel("3"));
        this.getContentPane().add(new JLabel("4"));

        this.setVisible(true);

        this.setVisible(true);
    }
}
