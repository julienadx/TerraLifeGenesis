package com.terra.machines;

import com.terra.tools.Environment;
import com.terra.tools.World;

public class Fire extends AntiMachine {

    public Fire(int level, int probability) {
        super(level, "com.terra.machines.Fire", probability, 4);
    }

    public Fire() {
        super(0, "com.terra.machines.Fire", 30, 4);
    }

    @Override
    public World action(World world) {
        world = super.action(world);
        int deads = world.getSpecies()[1].getPopulation() / ((Machine.levelMax + (this.getMaxProportion()/2)) - this.getLevel());
        world.getSpecies()[1].die(deads);
        this.setMessage(deads, world.getSpecies()[1].getName());
        return world;
    }

    @Override
    public Environment action(Environment environment) {
        int increaseTemperature = this.getLevel() * 30;
        environment.setTemperature(environment.getTemperature() + increaseTemperature);
        return environment;
    }
}
