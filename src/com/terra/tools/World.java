package com.terra.tools;

import com.terra.livings.*;
import com.terra.machines.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class World {

    private final static String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final static String[] dayOfWeeks = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    private Environment environment;
    private Species[] species = new Species[5];
    private Machine[] machines = new Machine[5];
    private AntiMachine[] disasters = new AntiMachine[4];
    private String name;
    private Calendar date;
    private boolean pause;

    public World(Environment environment) {
        /*for (int i=0; i<this.species.length; i++) {
            this.species[i] = new livings.Species(i+1);
        }*/
        //species
        this.species[0] = new Unicellular();
        this.species[0].setPopulation(30);
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
        this.date = Calendar.getInstance();
        this.pause = false;
    }

    public World() {
        this(new Environment());
    }

    public void grow() {

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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getFormattedDate() {
        return this.date.get(Calendar.DAY_OF_MONTH) + " " + months[this.date.get(Calendar.MONTH)] + " " + this.date.get(Calendar.YEAR);
    }

    public void incrementDate() {
        this.date.add(Calendar.DATE, 1);
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
