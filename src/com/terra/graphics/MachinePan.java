package com.terra.graphics;

import javax.swing.*;

public class MachinePan extends Pan {
    MachinePan() {
        super(6, "MACHINES");

        this.setValuesKind(new String[]{"minerals", "gravity", "temperature", "day cycle", "water"});


        //compounds
        JPanel[] subPan = new JPanel[getRows()];
        for (int i=0; i<getRows(); i++) {
            subPan[i] = new JPanel();
            this.getText()[i] = new JLabel(this.getValuesKind()[i] + ": level " + Integer.toString(this.getValues()[i]));
            subPan[i].add(this.getText()[i]);
            subPan[i].add(new JButton("upgrade"));
            this.add(subPan[i]);
        }
    }
}
