package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class GamePLayScreen extends JPanel {

    private EnvironmentPan environmentPan;

    GamePLayScreen() {
        super();
        this.setLayout(new GridLayout(2, 3));

        this.environmentPan = new EnvironmentPan();
        this.add(environmentPan);

        JPanel popPan = new JPanel();
        popPan.add(new JLabel("poppan"), BorderLayout.CENTER);
        this.add(popPan);

        JPanel planetPan = new JPanel();
        planetPan.add(new JLabel("planetpan"), BorderLayout.CENTER);
        this.add(planetPan);

        JPanel machinePan = new JPanel();
        machinePan.add(new JLabel("machinepan"), BorderLayout.CENTER);
        this.add(machinePan);

        JPanel disordersPan = new JPanel();
        disordersPan.add(new JLabel("disorderspan"), BorderLayout.CENTER);
        this.add(disordersPan);

        JPanel logsPan = new JPanel();
        logsPan.add(new JLabel("logspan"), BorderLayout.CENTER);
        this.add(logsPan);
    }

    public EnvironmentPan getEnvironmentPan() {
        return environmentPan;
    }
}
