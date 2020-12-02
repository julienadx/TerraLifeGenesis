public class GravityMachine extends Machine {
    GravityMachine(int level, String name) {
        super(level, name);
    }

    @Override
    public Environment action(Environment environment) {

        environment.setGravity(environment.getGravity() + (this.getLevel() * 5));

        return environment;
    }
}
