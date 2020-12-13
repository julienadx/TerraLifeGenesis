package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class GamePLayScreen extends JPanel {

    private EnvironmentPan environmentPan;
    private PopulationPan populationPan;
    private MachinePan machinePan;
    private DisorderPan disorderPan;

    GamePLayScreen() {
        super();
        this.setLayout(new GridLayout(2, 3));

        this.environmentPan = new EnvironmentPan();
        this.add(environmentPan);

        this.populationPan = new PopulationPan();
        this.add(populationPan);

        JPanel planetPan = new JPanel();
        planetPan.add(new JLabel("planetpan"), BorderLayout.CENTER);
        this.add(planetPan);

        this.machinePan = new MachinePan();
        this.add(machinePan);

        this.disorderPan = new DisorderPan();
        this.add(disorderPan);

        JPanel logsPan = new JPanel();
        logsPan.add(new JLabel("logspan"), BorderLayout.CENTER);
        this.add(logsPan);
    }

    public EnvironmentPan getEnvironmentPan() {
        return environmentPan;
    }
}
