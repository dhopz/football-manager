package example;

import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private static Random random;
    public static void createRandom() {
        random  = new Random();
    }
    public static String getRandomEvent(String[] array) {
        createRandom();
        int rnd = random.nextInt(array.length);
        return array[rnd];
    }

    public static String getRandomPlayer(List<Player> players){
        createRandom();
        Player player = players.get(random.nextInt(players.size()));
        return player.playerDetails();
    }

}
