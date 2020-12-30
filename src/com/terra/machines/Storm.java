package com.terra.machines;

import com.terra.tools.Environment;
import com.terra.tools.World;

public class Storm extends AntiMachine {

    public Storm(int level, int probability) {
        super(level, "com.terra.machines.Storm", probability, 3);
    }

    public Storm() {
        super(0, "com.terra.machines.Storm", 9, 3);
    }

    @Override
    public Environment action(Environment environment) {

        return environment;
    }

    @Override
    public World action(World world) {
        super.action(world);
        world.getEnvironment().setTemperature(world.getEnvironment().getTemperature() - this.getLevel() * 20);
        return world;
    }
}
