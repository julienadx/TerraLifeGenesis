package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class EnvironmentPan extends JPanel {

    private int oxyValue;
    private JLabel oxyText;

    EnvironmentPan() {
        super();
        this.setLayout(new GridLayout(7, 1));

        this.oxyValue = 0;

        //title
        JPanel title = new JPanel();
        title.setLayout(new BorderLayout());
        title.add(new JLabel("ENVIRONMENT"));

        //compound 0
        JPanel oxyPan = new JPanel();
        this.oxyText = new JLabel("oxygen: " + Integer.toString(oxyValue));
        oxyPan.add(oxyText);

        //adding
        this.add(title);
        this.add(oxyPan);
    }

    public void modifyValue(int value) {
        this.oxyText.setText("oxygen: " + Integer.toString(value));
    }
}
