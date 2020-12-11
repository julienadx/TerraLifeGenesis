package com.terra.livings;

import com.terra.tools.Environment;

import java.util.Objects;

public class Species {

    private Environment ideal_environment;
    private int level;
    private int population;
    private int eat;
    private int reproduction;
    private int die;
    private int evolution;
    private int biomass;
    private int nbr_reproduction;
    private String name;

    Species(int level) {
        this.name = "unknown";
        this.nbr_reproduction = 0;
        this.level = level;
        this.population = 0;
        this.eat = level * 10;
        this.reproduction = 30 / level;
        this.die = level * 10;
        this.evolution = level * 10;
        this.biomass = level * 2;
        this.ideal_environment = new Environment(level * 6, level * 6, level * 6, level * 6, level * 6, level * 6);
    }

    Species(Environment environment, int level, int eat, int reproduction, int die, int evolution, int biomass) {
        this.name = "unknown";
        this.nbr_reproduction = 0;
        this.level = level;
        this.population = 0;
        this.eat = eat;
        this.reproduction = reproduction;
        this.die = die;
        this.evolution = evolution;
        this.biomass = biomass;
        this.ideal_environment = environment;
    }

    public void die(int dead) {
        if (dead <= this.getPopulation() && dead != 0) {
            this.setPopulation(this.getPopulation() - dead);
        } else {
            this.setPopulation(0);
        }
    }

    public void reproduction() {
        if (this.getPopulation() != 0) {
            this.setPopulation((this.getPopulation() / 5) + this.getPopulation());
        } else {
            this.setPopulation(5);
        }
        this.setNbr_reproduction(1);
    }

    public Species[] eat(Species[] species) {
        for (int a=0; a<species[a].getLevel()-1; a++) {
            species[a].die(this.getPopulation() / 5);
        }
        return species;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
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
                biomass == species.biomass &&
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
        return biomass;
    }

    public void setBiomass(int biomass) {
        this.biomass = biomass;
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
}
