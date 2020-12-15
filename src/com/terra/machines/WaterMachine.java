package com.terra.machines;

import com.terra.tools.Environment;

public class WaterMachine extends Machine {
    public WaterMachine() {
        super(0, "water machine");
    }

    @Override
    public Environment action(Environment environment) {

        environment.setWater(environment.getWater() + (this.getLevel() * 5));

        return environment;
    }
}
