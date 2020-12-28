package com.terra.tools;

import com.terra.livings.*;
import com.terra.machines.*;

import java.util.Arrays;
import java.util.Objects;

public class World {

    private Environment environment;
    private Species[] species = new Species[5];
    private Machine[] machines = new Machine[5];
    private AntiMachine[] disasters = new AntiMachine[4];
    private String name;
    private int date;
    private boolean pause;

    public World(Environment environment) {
        /*for (int i=0; i<this.species.length; i++) {
            this.species[i] = new livings.Species(i+1);
        }*/
        //species
        this.species[0] = new Unicellular();
        this.species[0].setPopulation(20);
        this.species[1] = new Vegetables();
        this.species[2] = new Pisces();
        this.species[3] = new Insects();
        this.species[4] = new Mammals();

        //machines
        this.machines[0] = new MineralMachine();
        this.machines[1] = new GravityMachine();
        this.machines[2] = new TemperatureMachine();
        this.machines[3] = new DayNightMachine();
        this.machines[4] = new WaterMachine();

        //disorders
        this.disasters[0] = new Disease();
        this.disasters[1] = new Meteor();
        this.disasters[2] = new Fire();
        this.disasters[3] = new Storm();

        this.environment = environment;
        this.name = "unknown";
        this.date = 0;
        this.pause = false;
    }

    public World() {
        this(new Environment());
    }

    public void grow() {
        int rand;
        for (int i=0; i<this.species.length; i++) {
            for (int a=0; a<this.machines.length; a++) {
                this.environment = machines[a].action(this.environment);
            }
            rand = (int) (Math.random() * (100 - 1 + 1) + 1);
            if (this.environment.isEnough(this.species[i].getIdeal_environment())) {
                if (rand <= this.species[i].getReproduction()) {
                    //reproduction case
                    this.getSpecies()[i].reproduction();
                    //oxygen
                    try {
                        this.getEnvironment().setOxygen(this.getEnvironment().getOxygen() + (this.getEnvironment().getOxygen() / this.getSpecies()[i].getPopulation()));
                    } catch(Exception e) {
                        //code
                    }
                    if (this.getSpecies()[i].getNbr_reproduction() % this.getSpecies()[i].getEat() == 0) {
                        //eat case
                        this.setSpecies(this.getSpecies()[i].eat(this.getSpecies()));
                        this.getEnvironment().setMinerals(this.getEnvironment().getMinerals() - (this.getSpecies()[i].getPopulation() % 20));
                    }
                    if (this.getSpecies()[i].getNbr_reproduction() % this.getSpecies()[i].getDie() == 0) {
                        //die case
                        this.getSpecies()[i].die(this.getSpecies()[i].getPopulation() / 10);
                    }
                    if (this.getSpecies()[i].getNbr_reproduction() % this.getSpecies()[i].getEvolution() == 0) {
                        //evolution case
                        try {
                            this.species[i+1].setPopulation((this.species[i].getPopulation() / 5) + this.species[i+1].getPopulation());
                            this.species[i].die(this.species[i].getPopulation() / 5);
                        } catch (Exception e) {
                            //code
                        }
                    }
                }
            } else {
                this.getSpecies()[i].die(this.getSpecies()[i].getPopulation() / 10);
            }
        }
    }

    public int getWorldBiomass() {
        int biomass = 0;
        for (int i=0; i<this.species.length; i++) {
            biomass += (this.species[i].getBiomass() * this.species[i].getPopulation());
        }
        return biomass;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public AntiMachine[] getDisasters() {
        return disasters;
    }

    public void setDisasters(AntiMachine[] disasters) {
        this.disasters = disasters;
    }

    public void setSpecies(Species[] species) {
        this.species = species;
    }

    public Species[] getSpecies() {
        return species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        World world = (World) o;
        return Objects.equals(environment, world.environment) &&
                Arrays.equals(species, world.species);
    }

    @Override
    public String toString() {
        return name + "{" +
                "environment=" + environment +
                ", biomass=" + this.getWorldBiomass() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Machine[] getMachines() {
        return machines;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
