import java.util.Objects;

public class Environment {

    private int oxygen;
    private int temperature;
    private int gravity;
    private int dayNight;
    private int water;
    private int minerals;

    Environment(int oxygen, int temperature, int dayNight, int gravity, int water, int minerals) {
        this.oxygen = oxygen;
        this.temperature = temperature;
        this.dayNight = dayNight;
        this.gravity = gravity;
        this.water = water;
        this.minerals = minerals;
    }

    Environment() {
        this(15, 100, 100, 100, 100, 100);
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

    public boolean isEnough(Environment environment) {
        if (environment == null) return false;
        return this.oxygen >= environment.getOxygen() &&
                this.water >= environment.getWater() &&
                this.temperature >= environment.getTemperature() &&
                this.gravity >= environment.getGravity() &&
                this.minerals >= environment.getMinerals() &&
                this.dayNight >= environment.getDayNight();
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
        return "Environment{" +
                "oxygen=" + oxygen +
                ", temperature=" + temperature +
                ", gravity=" + gravity +
                ", dayNight=" + dayNight +
                ", minerals=" + minerals +
                ", water=" + water +
                '}';
    }
}
