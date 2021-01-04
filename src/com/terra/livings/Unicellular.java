package com.terra.livings;

import com.terra.tools.Environment;

public class Unicellular extends Species {

    public Unicellular() {
        super(new Environment(2, 2, 1, 3, 2, 3), 1, 2, 60, 5, 70, 2);
        this.setName("unicellular");
    }
}
