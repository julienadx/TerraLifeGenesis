package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

//TODO to work here
public class GameWindow extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel gameScreen = new JPanel();

    public GameWindow() {
        this.setTitle("Terra Life Genesis v0.2");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);





        this.gameScreen.setLayout(new GridLayout(2, 2));
        this.gameScreen.add(new EnvironmentPan());
        this.gameScreen.add(new PopulationPan());
        this.gameScreen.add(new MachinePan());
        this.gameScreen.add(new AntiMachinePan());

        this.setContentPane(gameScreen);

        this.setVisible(true);

        this.setVisible(true);
    }
}
