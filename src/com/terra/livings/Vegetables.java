package com.terra.livings;

import com.terra.tools.Environment;

public class Vegetables extends Species {

    public Vegetables() {
        super(new Environment(3, 300, 30, 30, 10, 20), 2, 3, 30, 30, 30, 20);
        this.setName("vegetables");
    }
}
