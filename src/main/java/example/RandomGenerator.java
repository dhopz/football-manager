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
    public static Player getRandomPlayer(List<Player> players){
        createRandom();
        return players.get(random.nextInt(players.size()));
    }

    public static String getRandomPlayerName(List<Player> players){
        createRandom();
        Player player = players.get(random.nextInt(players.size()));
        return player.playerDetails();
    }

    public static int randomPlay(){
        return random.nextInt(2);
    }

    public static int randomNumber(){
        return random.nextInt(100);
    }

}
