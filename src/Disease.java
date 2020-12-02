public class Disease extends AntiMachine {

    Disease(int level, int probability) {
        super(level, "Disease", probability, 2);
    }

    Disease() {
        super(1, "Disease", 30, 2);
    }

    @Override
    public Environment action(Environment environment) {
        int decreaseWater = this.getLevel() * 40;
        environment.setWater(environment.getWater() - decreaseWater);
        return environment;
    }
}
