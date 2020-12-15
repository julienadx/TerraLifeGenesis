package com.terra.graphics;

import javax.swing.*;

public class MachinePan extends Pan {

    private UpgradeButton[] upgradeButton;

    MachinePan() {
        super(6, "MACHINES");

        this.setValuesKind(new String[]{"minerals", "gravity", "temperature", "day cycle", "water"});


        for (int i=0; i<this.getValuesKind().length; i++) {
            this.upgradeButton[i] = new UpgradeButton(i, "upgrade");
        }

        //compounds
        JPanel[] subPan = new JPanel[getRows()];
        for (int i=0; i<getRows(); i++) {
            subPan[i] = new JPanel();
            this.getText()[i] = new JLabel(this.getValuesKind()[i] + ": level " + Integer.toString(this.getValues()[i]));
            subPan[i].add(this.getText()[i]);
            subPan[i].add(upgradeButton[i]);
            this.add(subPan[i]);
        }
    }

    public JButton[] getUpgradeButton() {
        return upgradeButton;
    }
}
