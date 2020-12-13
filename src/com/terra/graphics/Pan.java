package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

public class Pan extends JPanel {

    private String name;
    private int rows;

    private String[] valuesKind;

    private int[] values;
    private JLabel[] text;

    Pan(int rows, String name) {
        super();

        this.rows = rows;
        this.name = name;

        this.valuesKind = new String[this.getRows()];

        this.values = new int[this.getRows()];
        this.text = new JLabel[getRows()];

        this.setLayout(new GridLayout(this.rows, 1));

        //title
        JPanel title = new JPanel();
        title.setLayout(new BorderLayout());
        title.add(new JLabel(this.name));

        this.add(title);

    }

    //rows without title
    public int getRows() {
        return rows-1;
    }

    public void modifyValue(int value, int index) {
        this.getValues()[index] = value;
        this.getText()[index].setText(this.valuesKind[index] + ": " + Integer.toString(value));
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public JLabel[] getText() {
        return text;
    }

    public void setText(JLabel[] text) {
        this.text = text;
    }

    public void setValuesKind(String[] valuesKind) {
        this.valuesKind = valuesKind;
    }

    public String[] getValuesKind() {
        return valuesKind;
    }

    @Override
    public String getName() {
        return name;
    }
}
