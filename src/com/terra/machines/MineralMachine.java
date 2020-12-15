package com.terra.machines;

import com.terra.tools.Environment;

public class MineralMachine extends Machine {

    public MineralMachine() {
        super(0, "mineral machine");
    }

    @Override
    public Environment action(Environment environment) {

        environment.setMinerals(environment.getMinerals() + (this.getLevel() * 5));

        return environment;
    }
}
