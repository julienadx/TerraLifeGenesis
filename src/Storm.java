public class Storm extends AntiMachine {

    Storm(int level, int probability) {
        super(level, "Storm", probability, 3);
    }

    Storm() {
        super(1, "Storm", 30, 3);
    }

    @Override
    public Environment action(Environment environment) {
        int increaseTemperature = this.getLevel() * 20;
        environment.setTemperature(environment.getTemperature() - increaseTemperature);
        return environment;
    }
}
