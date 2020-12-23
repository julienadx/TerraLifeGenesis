package com.terra.tools;

import com.terra.exceptions.NoMoneyException;
import com.terra.machines.*;

import java.util.Objects;

public class Player {

    private World world;
    private int dollars;
    private AntiMachine[] disasters = new AntiMachine[4];

    public Player(World world, int dollars) {
        this.world = world;
        this.dollars = dollars;
        this.disasters[0] = new Disease();
        this.disasters[1] = new Meteor();
        this.disasters[2] = new Fire();
        this.disasters[3] = new Storm();
    }

    public void yearCompleted() {
        try {
            this.addDollars(this.getWorld().getWorldBiomass() * 10);
            for (int i=0; i<this.getWorld().getSpecies().length; i++) {
                this.addDollars(this.getWorld().getSpecies()[i].getLevel() * this.getWorld().getSpecies()[i].getPopulation());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public AntiMachine[] getDisasters() {
        return disasters;
    }

    public void setDisasters(AntiMachine[] disasters) {
        this.disasters = disasters;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void purchase(int price) {
        if (price >= this.getDollars()) {
            this.setDollars(this.getDollars() - price);
        }
    }

    public void addDollars(int dollars) throws NoMoneyException {
        if (this.getDollars() + dollars >= 0) {
            this.setDollars(this.getDollars() + dollars);
        } else {
            throw new NoMoneyException("Error: you try to buy $" + Integer.toString(Math.abs(dollars)) + " with $" + Integer.toString(this.getDollars()));
        }
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return dollars == player.dollars &&
                Objects.equals(world, player.world);
    }

    @Override
    public String toString() {
        return "world=" + world +
                ", dollars=" + dollars +
                world.getSpecies()[0] +
                world.getSpecies()[1] +
                world.getSpecies()[2] +
                world.getSpecies()[3] +
                world.getSpecies()[4] +
                '}';
    }
}
