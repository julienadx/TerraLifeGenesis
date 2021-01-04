package com.terra.machines;

import com.terra.data.MachinesData;
import com.terra.tools.World;

public abstract class AntiMachine extends Machine {

    private int probability;
    private String message;
    private int maxProportion;

    public AntiMachine(int level, String name, int probability, int maxProportion) {
        super(level, name);
        this.probability = probability;
        this.message = "";
        this.maxProportion = maxProportion;
    }

    public AntiMachine(String name) {
        this(0, name, 0, 0);
    }

    public AntiMachine() {
        this(1, "AntiMachine", 30, 2);
    }

    public World action(World world) {
        for (int i=0; i<world.getSpecies().length; i++) {
            int deads = world.getSpecies()[i].getPopulation() / ((MachinesData.MAX_LEVEL.getValue() + 2) - this.getLevel());
            world.getSpecies()[i].die(deads);
            world.setEnvironment(this.action(world.getEnvironment()));
            this.setMessage(deads, world.getSpecies()[i].getName());
        }
        return world;
    }

    public void setMessage(int deads, String speciesName) {
        if (deads != 0) {
            if (!this.message.equals("")) {
                this.message += "\n";
            }
            this.message += "[-] " + this.getName() + " killed " + Integer.toString(deads) + " individuals of species " +  speciesName;
        }
    }

    public String getMessage() {
        String m = this.message;
        this.message = "";
        return m;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getProbability() {
        return this.probability;
    }

    @Override
    public String toString() {
        return "com.terra.machines.AntiMachine{" +
                super.toString() +
                ", probability=" + probability +
                '}';
    }

    public int getMaxProportion() {
        return maxProportion;
    }

    public void setMaxProportion(int maxProportion) {
        this.maxProportion = maxProportion;
    }
}
