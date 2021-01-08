package com.terra.tools;

import com.terra.livings.Species;

public class Environment {

    private int oxygen;
    private int temperature;
    private int gravity;
    private int dayNight;
    private int water;
    private int minerals;

    public Environment(int oxygen, int temperature, int dayNight, int gravity, int water, int minerals) {
        this.oxygen = oxygen;
        this.temperature = temperature;
        this.dayNight = dayNight;
        this.gravity = gravity;
        this.water = water;
        this.minerals = minerals;
    }

    public Environment() {
        int[] values = new int[6];
        for (int i=0; i< values.length; i++) {
            values[i] = (int) (Math.random() * 150 + 50);
        }
        this.oxygen = values[0];
        this.temperature = values[1];
        this.dayNight = values[2];
        this.gravity = values[3];
        this.water = values[4];
        this.minerals = values[5];
    }

    Environment(Environment environment) {
        this(environment.oxygen, environment.temperature, environment.dayNight, environment.gravity, environment.water, environment.minerals);
    }

    private int noNegative(int value, int max) {
        if (value + max <= 0) {
            return 0;
        } else {
            return value;
        }
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = noNegative(oxygen, this.oxygen);
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = noNegative(temperature, this.temperature);
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = noNegative(gravity, this.gravity);
    }

    public int getDayNight() {
        return dayNight;
    }

    public void setDayNight(int dayNight) {
        this.dayNight = noNegative(dayNight, this.dayNight);
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = noNegative(water, this.water);
    }

    public int getMinerals() {
        return minerals;
    }

    public void setMinerals(int minerals) {
        this.minerals = noNegative(minerals, this.minerals);
    }

    public boolean isEnough(Species species) {
        return this.oxygen >= species.getIdeal_environment().getOxygen() * species.getPopulation() &&
                this.water >= species.getIdeal_environment().getWater() * species.getPopulation() &&
                this.temperature >= species.getIdeal_environment().getTemperature() * species.getPopulation() &&
                this.gravity >= species.getIdeal_environment().getGravity() * species.getPopulation() &&
                this.minerals >= species.getIdeal_environment().getMinerals() * species.getPopulation() &&
                this.dayNight >= species.getIdeal_environment().getDayNight() * species.getPopulation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Environment that = (Environment) o;
        return oxygen == that.oxygen &&
                temperature == that.temperature &&
                gravity == that.gravity &&
                dayNight == that.dayNight &&
                minerals == that.minerals &&
                water == that.water;
    }

    @Override
    public String toString() {
        return "com.terra.tools.Environment{" +
                "oxygen=" + oxygen +
                ", temperature=" + temperature +
                ", gravity=" + gravity +
                ", dayNight=" + dayNight +
                ", minerals=" + minerals +
                ", water=" + water +
                '}';
    }
}
