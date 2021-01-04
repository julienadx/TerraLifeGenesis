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
        this.setLayout(new GridLayout(1, 3));

        JPanel cards = new JPanel();
        cards.setLayout(new GridLayout(2, 1));

        JPanel cards01 = new JPanel();
        cards01.setLayout(new GridLayout(2, 1));

        this.environmentPan = new EnvironmentPan();
        cards.add(environmentPan);

        this.populationPan = new PopulationPan();
        cards01.add(populationPan);

        this.machinePan = new MachinePan();
        cards.add(machinePan);

        this.disorderPan = new DisorderPan();
        cards01.add(disorderPan);

        this.add(cards);
        this.add(cards01);

        this.logsPan = new LogsPan("[*] new game started!");
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
