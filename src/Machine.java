public abstract class Machine {

    private int level;
    private String name;
    protected static int levelMax = 7;

    Machine(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public abstract Environment action(Environment environment);

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
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

    @Override
    public String toString() {
        return "Machine{" +
                "level=" + level +
                ", name='" + name + '\'' +
                '}';
    }
}
