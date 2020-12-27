package com.terra.machines;

import com.terra.tools.Environment;

public class GravityMachine extends Machine {
    public GravityMachine() {
        super("gravity machine");
    }

    @Override
    public Environment action(Environment environment) {

        environment.setGravity(environment.getGravity() + (this.getLevel() * 5));

        return environment;
    }
}
