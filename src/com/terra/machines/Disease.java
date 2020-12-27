package com.terra.machines;

import com.terra.tools.Environment;

public class Disease extends AntiMachine {

    public Disease(int level, int probability) {
        super(level, "com.terra.machines.Disease", probability, 2);
    }

    public Disease() {
        super(0, "com.terra.machines.Disease", 30, 2);
    }

    @Override
    public Environment action(Environment environment) {
        int decreaseWater = this.getLevel() * 40;
        environment.setWater(environment.getWater() - decreaseWater);
        return environment;
    }
}
