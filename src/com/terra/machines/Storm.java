package com.terra.machines;

import com.terra.tools.Environment;

public class Storm extends AntiMachine {

    public Storm(int level, int probability) {
        super(level, "com.terra.machines.Storm", probability, 3);
    }

    public Storm() {
        super(0, "com.terra.machines.Storm", 30, 3);
    }

    @Override
    public Environment action(Environment environment) {
        int increaseTemperature = this.getLevel() * 20;
        environment.setTemperature(environment.getTemperature() - increaseTemperature);
        return environment;
    }
}
