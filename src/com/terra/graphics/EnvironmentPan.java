package com.terra.graphics;

import javax.swing.*;

public class EnvironmentPan extends Pan {

    EnvironmentPan() {
        super(7, "ENVIRONMENT");

        this.setValuesKind(new String[]{"oxygen", "day cycle", "minerals", "gravity", "temperature", "water"});


        //compounds
        JPanel[] subPan = new JPanel[getRows()];
        for (int i=0; i<getRows(); i++) {
            subPan[i] = new JPanel();
            this.getText()[i] = new JLabel(this.getValuesKind()[i] + ": " + Integer.toString(this.getValues()[i]));
            subPan[i].add(this.getText()[i]);
            this.add(subPan[i]);
        }

    }
}
