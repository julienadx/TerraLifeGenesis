public class MineralMachine extends Machine {

    MineralMachine(int level, String name) {
        super(level, name);
    }

    @Override
    public Environment action(Environment environment) {

        environment.setMinerals(environment.getMinerals() + (this.getLevel() * 5));

        return environment;
    }
}
