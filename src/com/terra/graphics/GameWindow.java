package com.terra.graphics;

import javax.swing.*;

//TODO to work here
public class GameWindow extends JFrame {

    //entire window
    private JPanel bigContainer;

    private JPanel statusBar;

    private GameScreen gameScreen;

    public GameWindow() {
        this.setTitle("Terra Life Genesis v0.3");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        this.bigContainer = new JPanel();
        this.setContentPane(bigContainer);





    }

    //TODO
    public void startGame() {
        //pass
    }
}
