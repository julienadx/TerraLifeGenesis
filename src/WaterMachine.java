public class WaterMachine extends Machine {
    WaterMachine(int level, String name) {
        super(level, name);
    }

    @Override
    public Environment action(Environment environment) {

        environment.setWater(environment.getWater() + (this.getLevel() * 5));

        return environment;
    }
}
