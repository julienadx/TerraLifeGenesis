package com.terra.graphics;

import javax.swing.*;

public class PopulationPan extends Pan {

    PopulationPan() {
        super(6, "POPULATION");

        this.setValuesKind(new String[]{"unicellular", "vegetables", "pisces", "insects", "mammals"});

        //compounds
        JPanel[] subPan = new JPanel[this.getRows()];
        for (int i=0; i<this.getRows(); i++) {
            subPan[i] = new JPanel();
            this.getText()[i] = new JLabel(this.getValuesKind()[i] + ": " + Integer.toString(this.getValues()[i]));
            subPan[i].add(this.getText()[i]);
            this.add(subPan[i]);
        }
    }
}
