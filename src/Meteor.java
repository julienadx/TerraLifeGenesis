public class Meteor extends AntiMachine {

    Meteor(int level, int probability) {
        super(level, "Meteor", probability, 3);
    }

    Meteor() {
        super(1, "Meteor", 30, 3);
    }

    @Override
    public Environment action(Environment environment) {
        int increaseTemperature = this.getLevel() * 100;
        environment.setTemperature(environment.getTemperature() + increaseTemperature);
        return environment;
    }
}
