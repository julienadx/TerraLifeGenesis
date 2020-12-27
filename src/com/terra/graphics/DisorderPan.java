package com.terra.graphics;

public class DisorderPan extends UpgradablePan {

    private UpgradeButton[] upgradeButton = new UpgradeButton[4];

    DisorderPan() {
        super(5, "NATURAL DISORDERS", new String[]{"disease", "meteor", "storm", "fire"});
    }
}
