package com.terra.graphics;

public class UpgradeButton extends GameButton {

    private String formatText;
    private String name;

    UpgradeButton(int index, String text, String context, String formatText) {
        super(context);
        this.formatText = formatText;
        this.setText(text);
        this.setIndex(index);
    }

    UpgradeButton(String text, String context, String formatText, String name) {
        this(0, text, context, formatText);
    }

    UpgradeButton(UpgradeButton button) {
        this(button.getIndex(), button.toString(), button.getContext(), button.getFormatText());
    }

    @Override
    public void setText(String text) {
        super.setText(this.getFormatText() + text);
    }

    @Override
    public String toString() {
        return String.valueOf(this.getIndex());
    }

    public String getFormatText() {
        return formatText;
    }

    public void setFormatText(String formatText) {
        this.formatText = formatText;
    }

    @Override
    public String getName() {
        return name;
    }
}
