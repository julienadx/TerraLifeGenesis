import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*

        World world = new World(new Environment());

        Player player = new Player(world, 1000);

        player.getWorld().getSpecies()[0].setPopulation(20);


        //game loop
        for (int i=0; i<12000; i++) {
            if (player.getWorld().getWorldBiomass() == 0) {
                System.out.println("you looooooooose!");
                break;
            } else if (player.getWorld().getWorldBiomass() >= 20000000) {
                System.out.println("you win! Congrats your planet is suitable for human beings!");
                break;
            }
            if (i % 10 == 0) {
                player.monthCompleted();
            }
            System.out.println("day " + i);
            player.getWorld().grow();
            System.out.println(player);
            Thread.sleep(1000);
        }
         */
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MONTH, 1);
        System.out.println(date.get(Calendar.MONTH));
    }
}
