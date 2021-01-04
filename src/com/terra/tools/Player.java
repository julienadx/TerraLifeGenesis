package com.terra.tools;

import com.terra.data.PlayerData;
import com.terra.exceptions.NoMoneyException;

import java.util.Objects;

public class Player {

    private World world;
    private int dollars;


    public Player(World world, int dollars) {
        this.world = world;
        this.dollars = dollars;
    }

    public int monthCompleted() {
        int earned = 0;
        int population = 0;
        earned += this.getWorld().getWorldBiomass();
        for (int i=0; i<this.getWorld().getSpecies().length; i++) {
            if (this.getWorld().getSpecies()[i].getPopulation() != 0) {
                earned += this.getWorld().getSpecies()[i].getLevel() * 100;
            }
        }
        earned /= 10;
        try {
            this.addDollars(earned);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            earned = -1;
        }
        return earned;
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

    public void reset() {
        this.setWorld(new World());
        this.setDollars(PlayerData.DOLLARS.getValue());
    }
}
