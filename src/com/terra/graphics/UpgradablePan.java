package com.terra.graphics;

import com.terra.data.MachinesData;

import javax.swing.*;
import java.awt.*;

public class UpgradablePan extends Pan {

    private UpgradeButton[] upgradeButton = new UpgradeButton[5];

    private UpgradeButton[] sellButton = new UpgradeButton[5];

    UpgradablePan(int rows, String name, String[] valuesKind) {
        super(rows, name);

        this.setValuesKind(valuesKind);

        String text = Integer.toString(MachinesData.PRICE.getValue());

        for (int i=0; i<this.getRows(); i++) {
            this.upgradeButton[i] = new UpgradeButton(i, text, name, "buy: $ ");
        }

        for (int i=0; i<this.getRows(); i++) {
            this.sellButton[i] = new UpgradeButton(i, text, name, "sell: $ ");
            this.sellButton[i].setEnabled(false);
        }

        //compounds
        JPanel[] subPan = new JPanel[getRows()];
        for (int i=0; i<getRows(); i++) {
            subPan[i] = new JPanel();
            subPan[i].setLayout(new FlowLayout());
            this.getText()[i] = new JLabel(this.getValuesKind()[i] + ": lv." + Integer.toString(this.getValues()[i]) + "/" + Integer.toString(MachinesData.MAX_LEVEL.getValue()));
            subPan[i].add(this.getText()[i]);
            subPan[i].add(upgradeButton[i]);
            subPan[i].add(sellButton[i]);
            this.add(subPan[i]);
        }
    }

    public JButton[] getUpgradeButton() {
        return upgradeButton;
    }

    public UpgradeButton[] getSellButton() {
        return sellButton;
    }
}
