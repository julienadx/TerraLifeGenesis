package com.terra.graphics;

public class UpgradeButton extends GameButton {

    UpgradeButton(int index, String text, String context) {
        super(context);
        this.setText(text);
        this.setIndex(index);
    }

    UpgradeButton(String text, String context) {
        this(0, text, context);
    }

    UpgradeButton(UpgradeButton button) {
        this(button.getIndex(), button.toString(), button.getContext());
    }

    @Override
    public void setText(String text) {
        super.setText("upgrade: $" + text);
    }

    @Override
    public String toString() {
        return String.valueOf(this.getIndex());
    }
}
