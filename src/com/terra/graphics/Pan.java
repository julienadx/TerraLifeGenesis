package com.terra.graphics;

import javax.swing.*;
import java.awt.*;

//TODO to work here
public class Pan extends JPanel {
    Pan(String title) {
        super();
        this.setLayout(new GridLayout(20, 1));
        this.add(new JLabel(title));
    }
}
