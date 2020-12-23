package com.terra.graphics;

import javax.swing.*;

public class UpgradablePan extends Pan {

    private UpgradeButton[] upgradeButton = new UpgradeButton[5];

    UpgradablePan(int rows, String name, String[] valuesKind) {
        super(rows, name);

        this.setValuesKind(valuesKind);

        for (int i=0; i<this.getRows(); i++) {
            this.upgradeButton[i] = new UpgradeButton(i, "upgrade");
        }

        //compounds
        JPanel[] subPan = new JPanel[getRows()];
        for (int i=0; i<getRows(); i++) {
            subPan[i] = new JPanel();
            this.getText()[i] = new JLabel(this.getValuesKind()[i] + ": lv." + Integer.toString(this.getValues()[i]));
            subPan[i].add(this.getText()[i]);
            subPan[i].add(upgradeButton[i]);
            this.add(subPan[i]);
        }
    }

    public JButton[] getUpgradeButton() {
        return upgradeButton;
    }
}
