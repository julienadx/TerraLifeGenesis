package com.terra.livings;

import com.terra.tools.Environment;

public class Insects extends Species {

    public Insects() {
        super(new Environment(70, 200, 40, 55, 60, 55), 4, 5, 65, 5, 8, 25);
        this.setName("insects");
    }

}
