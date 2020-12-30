package com.terra.machines;

import com.terra.tools.Environment;
import com.terra.tools.World;

public class Meteor extends AntiMachine {

    public Meteor(int level, int probability) {
        super(level, "com.terra.machines.Meteor", probability, 3);
    }

    public Meteor() {
        super(0, "com.terra.machines.Meteor", 4, 3);
    }

    @Override
    public World action(World world) {
        super.action(world);
        world.getEnvironment().setTemperature(world.getEnvironment().getTemperature() + this.getLevel() * 100);
        return world;
    }

    @Override
    public Environment action(Environment environment) {

        return environment;
    }
}
