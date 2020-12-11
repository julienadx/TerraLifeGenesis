package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

//TODO to work here
public class Pan extends JPanel {
    Pan(String title, int cols) {
        super();
        this.setLayout(new GridLayout(1, cols));
        this.add(new JLabel(title));
    }
}
