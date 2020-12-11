package com.terra.machines;

import com.terra.tools.Environment;

public class DayNightMachine extends Machine {

    DayNightMachine(int level, String name) {
        super(level, name);
    }

    @Override
    public Environment action(Environment environment) {

        environment.setDayNight(environment.getDayNight() + (this.getLevel() * 5));

        return environment;
    }
}
