public abstract class AntiMachine extends Machine {

    //tesetesetest SALUT C JULIEN
    private int probability;
    private String message;
    private int maxProportion;

    AntiMachine(int level, String name, int probability, int maxProportion) {
        super(level, name);
        this.probability = probability;
        this.message = "";
        this.maxProportion = maxProportion;
    }

    AntiMachine() {
        this(1, "AntiMachine", 30, 2);
    }

    public World action(World world) {
        for (int i=0; i<world.getSpecies().length; i++) {
            int deads = world.getSpecies()[i].getPopulation() / ((Machine.levelMax + 2) - this.getLevel());
            world.getSpecies()[i].die(deads);
            world.setEnvironment(this.action(world.getEnvironment()));
            this.setMessage(deads, world.getSpecies()[i].getName());
        }
        return world;
    }

    public void setMessage(int deads, String speciesName) {
        this.message += "The " + this.getName() + " killed " + Integer.toString(deads) + " individuals of species " +  speciesName + "\n";
    }

    public String getMessage() {
        String m = this.message;
        this.message = "";
        return m;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getProbability() {
        return probability;
    }

    @Override
    public String toString() {
        return "AntiMachine{" +
                super.toString() +
                ", probability=" + probability +
                '}';
    }

    public int getMaxProportion() {
        return maxProportion;
    }

    public void setMaxProportion(int maxProportion) {
        this.maxProportion = maxProportion;
    }
}
