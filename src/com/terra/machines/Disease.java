package com.terra.machines;

import com.terra.data.MachinesData;
import com.terra.tools.Environment;
import com.terra.tools.World;

public class Disease extends AntiMachine {

    public Disease(int level, int probability) {
        super(level, "Disease", probability, 2);
    }

    public Disease() {
        super(0, "Disease", MachinesData.PROB_DISEASE.getValue(), 2);
    }


    @Override
    public World action(World world) {
        super.action(world);
        world.getEnvironment().setWater(world.getEnvironment().getWater() - this.getLevel() * 40);
        return world;
    }

    @Override
    public Environment action(Environment environment) {

        return environment;
    }
}
