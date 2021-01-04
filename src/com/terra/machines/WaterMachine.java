package com.terra.machines;

import com.terra.data.MachinesData;
import com.terra.tools.Environment;

public class WaterMachine extends Machine {
    public WaterMachine() {
        super("water machine");
    }

    @Override
    public Environment action(Environment environment) {

        environment.setWater(environment.getWater() + (this.getLevel() * MachinesData.INCOME.getValue()));

        return environment;
    }
}
