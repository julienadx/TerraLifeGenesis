package com.terra.machines;

import com.terra.tools.Environment;

public class DayNightMachine extends Machine {

    public DayNightMachine() {
        super("day cycle machine");
    }

    @Override
    public Environment action(Environment environment) {

        environment.setDayNight(environment.getDayNight() + (this.getLevel() * 5));

        return environment;
    }
}
