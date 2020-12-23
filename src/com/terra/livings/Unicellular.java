package com.terra.livings;

import com.terra.tools.Environment;

public class Unicellular extends Species {

    public Unicellular() {
        super(new Environment(3, 100, 5, 15, 7, 15), 1, 2, 60, 5, 20, 2);
        this.setName("unicellular");
    }
}