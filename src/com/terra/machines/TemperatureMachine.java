package com.terra.machines;

import com.terra.tools.Environment;

public class TemperatureMachine extends Machine {

    public TemperatureMachine(int level, String name) {
        super(level, name);
    }

    @Override
    public Environment action(Environment environment) {

        environment.setTemperature(environment.getTemperature() + (this.getLevel() * 5));

        return environment;
    }
}
