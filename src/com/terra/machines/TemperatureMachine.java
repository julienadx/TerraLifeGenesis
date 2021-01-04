package com.terra.machines;

import com.terra.data.MachinesData;
import com.terra.tools.Environment;

public class TemperatureMachine extends Machine {

    public TemperatureMachine() {
        super("temperature machine");
    }

    @Override
    public Environment action(Environment environment) {

        environment.setTemperature(environment.getTemperature() + (this.getLevel() * MachinesData.INCOME.getValue()));

        return environment;
    }
}
