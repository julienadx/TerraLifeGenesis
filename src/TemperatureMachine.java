public class TemperatureMachine extends Machine {

    TemperatureMachine(int level, String name) {
        super(level, name);
    }

    @Override
    public Environment action(Environment environment) {

        environment.setTemperature(environment.getTemperature() + (this.getLevel() * 5));

        return environment;
    }
}
