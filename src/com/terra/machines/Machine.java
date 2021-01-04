package com.terra.machines;

import com.terra.data.MachinesData;
import com.terra.tools.Environment;

public abstract class Machine {

    private int level;
    private String name;

    public Machine(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public Machine(String name) {
        this(0, name);
    }

    public abstract Environment action(Environment environment);

    public void levelUp() {
        if(this.getLevel() < MachinesData.MAX_LEVEL.getValue()) {
            this.setLevel(this.getLevel() + 1);
        }
    }

    public void levelDown() {
        if (this.getLevel() > 0) {
            this.setLevel(this.getLevel() - 1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        int price;
        if (this.getLevel() != 0) {
            price = (int) Math.pow((double) this.getLevel(), 2) * MachinesData.PRICE.getValue() + (100 * this.getLevel());
        } else {
            price = MachinesData.PRICE.getValue();
        }
        return price;
    }

    @Override
    public String toString() {
        return "com.terra.machines.Machine{" +
                "level=" + level +
                ", name='" + name + '\'' +
                '}';
    }
}
