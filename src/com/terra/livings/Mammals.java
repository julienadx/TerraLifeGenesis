package com.terra.livings;

import com.terra.tools.Environment;

public class Mammals extends Species {

    public Mammals() {
        super(new Environment(90, 320, 50, 70, 80, 40), 5, 1, 40, 10, 10, 40);
        this.setName("mammals");
    }
}
