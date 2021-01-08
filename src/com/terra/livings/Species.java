package com.terra.livings;

import com.terra.data.LivingsData;
import com.terra.tools.Environment;
import com.terra.tools.World;

import java.util.Objects;

public class Species {

    private Environment ideal_environment;
    private int level;
    private int population;
    private int eat;
    private int reproduction;
    private int die;
    private int evolution;
    private int nbr_reproduction;
    private String name;

    private int probAction;


    Species(int level) {
        this.name = "unknown";
        this.nbr_reproduction = 0;
        this.level = level;
        this.population = 0;
        this.eat = level * 10;
        this.reproduction = 30 / level;
        this.die = level * 10;
        this.evolution = level * 10;
        this.ideal_environment = new Environment(level * 6, level * 6, level * 6, level * 6, level * 6, level * 6);
    }

    Species(String name, Environment environment, int level, int eat, int reproduction, int die, int evolution, int probAction) {
        this.name = name;
        this.nbr_reproduction = 0;
        this.level = level;
        this.population = 0;
        this.eat = eat;
        this.reproduction = reproduction;
        this.die = die;
        this.evolution = evolution;
        this.ideal_environment = environment;
        this.probAction = probAction;
    }

    public static World speciesAction(World world, int index) {
        //reproduction
        world.getSpecies()[index].reproduction();
        //eat
        if (world.getSpecies()[index].getNbr_reproduction() % world.getSpecies()[index].eat == 0) {
            //drink
            world.setSpecies(world.getSpecies()[index].eat(world.getSpecies()));
            //breath
            if (world.getSpecies()[index].getName() == "unicellular" || world.getSpecies()[index].getName() == "vegetables" ) {
                world.getEnvironment().setMinerals(world.getEnvironment().getMinerals() - world.getSpecies()[index].getIdeal_environment().getMinerals());
                world.getEnvironment().setOxygen(world.getEnvironment().getOxygen() + world.getSpecies()[index].getIdeal_environment().getOxygen() * world.getSpecies()[index].getPopulation());
            } else {
                world.getEnvironment().setOxygen(world.getEnvironment().getOxygen() - world.getSpecies()[index].getIdeal_environment().getOxygen());
            }
        }
        //evolution
        if (world.getSpecies()[index].getLevel() < LivingsData.LEVEL_MAX.getValue() && world.getSpecies()[index].getNbr_reproduction() % world.getSpecies()[index].evolution == 0) {
            world.getSpecies()[world.getSpecies()[index].getLevel()+1].setPopulation((world.getSpecies()[index].getPopulation() / 10) + world.getSpecies()[world.getSpecies()[index].getLevel()+1].getPopulation());
            world.getSpecies()[index].die();
        }
        //die
        if (world.getSpecies()[index].getNbr_reproduction() % world.getSpecies()[index].die == 0) {
            int deads = world.getSpecies()[index].die();
        }
        return world;
    }

    public int die() {
        int dead = this.getPopulation() / this.die;
        this.setPopulation(this.getPopulation() - dead);
        return dead;
    }

    public int die(int dead) {
        if (dead == -1) {
            dead = this.getPopulation();
            this.setPopulation(0);
        }else if (dead <= this.getPopulation()) {
            this.setPopulation(this.getPopulation() - dead);
        } else {
            this.setPopulation(0);
            dead = this.getPopulation();
        }
        return dead;
    }

    public void reproduction() {
        this.setPopulation((this.getPopulation() / this.reproduction) + this.getPopulation());
        this.setNbr_reproduction(1);
    }

    public Species[] eat(Species[] species) {
        for (int a=0; a<species[a].getLevel()-1; a++) {
            species[a].die();
        }
        return species;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void growPopulation(int addPopulation) {
        if (addPopulation > 0 || Math.abs(addPopulation) > this.getPopulation()) {
            this.setPopulation(this.getPopulation() + (this.getPopulation() / addPopulation));
        } else {
            this.setPopulation(0);
        }
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public int getReproduction() {
        return reproduction;
    }

    public void setReproduction(int reproduction) {
        this.reproduction = reproduction;
    }

    public int getDie() {
        return die;
    }

    public void setDie(int die) {
        this.die = die;
    }

    public int getEvolution() {
        return evolution;
    }

    public void setEvolution(int evolution) {
        this.evolution = evolution;
    }

    public Environment getIdeal_environment() {
        return ideal_environment;
    }

    public void setIdeal_environment(Environment ideal_environment) {
        this.ideal_environment = ideal_environment;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Species species = (Species) o;
        return level == species.level &&
                population == species.population &&
                eat == species.eat &&
                reproduction == species.reproduction &&
                die == species.die &&
                evolution == species.evolution &&
                Objects.equals(ideal_environment, species.ideal_environment);
    }

    /*
    @Override
    public String toString() {
        return "livings.Species{" +
                "ideal_environment=" + ideal_environment +
                ", level=" + level +
                ", population=" + population +
                ", eat=" + eat +
                ", reproduction=" + reproduction +
                ", die=" + die +
                ", evolution=" + evolution +
                ", biomass=" + biomass +
                '}';
    }*/

    @Override
    public String toString() {
        return " | " + name + ": " + population + "(" + nbr_reproduction + ")";
    }

    public int getBiomass() {
        return LivingsData.BIOMASS.getValue() * (this.getLevel() + 1);
    }

    public int getNbr_reproduction() {
        return nbr_reproduction;
    }

    public void setNbr_reproduction(int nbr_reproduction) {
        this.nbr_reproduction += nbr_reproduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProbAction() {
        return probAction;
    }

    public void setProbAction(int probAction) {
        this.probAction = probAction;
    }
}
