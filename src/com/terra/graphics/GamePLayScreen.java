package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class GamePLayScreen extends JPanel {

    private EnvironmentPan environmentPan;
    private PopulationPan populationPan;
    private MachinePan machinePan;
    private DisorderPan disorderPan;
    private LogsPan logsPan;

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

        this.logsPan = new LogsPan("new game started!");
        this.add(logsPan);
    }

    public EnvironmentPan getEnvironmentPan() {
        return environmentPan;
    }

    public PopulationPan getPopulationPan() {
        return populationPan;
    }

    public MachinePan getMachinePan() {
        return machinePan;
    }

    public DisorderPan getDisorderPan() {
        return disorderPan;
    }

    public LogsPan getLogsPan() {
        return logsPan;
    }
}
