package com.terra.machines;

import com.terra.tools.Environment;

public class Meteor extends AntiMachine {

    public Meteor(int level, int probability) {
        super(level, "com.terra.machines.Meteor", probability, 3);
    }

    public Meteor() {
        super(1, "com.terra.machines.Meteor", 30, 3);
    }

    @Override
    public Environment action(Environment environment) {
        int increaseTemperature = this.getLevel() * 100;
        environment.setTemperature(environment.getTemperature() + increaseTemperature);
        return environment;
    }
}
