package example;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Random;

public class Action {
    private final String homeTeam;
    private final String awayTeam;
    private List<Object> gameLog = new ArrayList<>();
    private List<Player> homePlayers;
    public Action(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam.getLongName();
        this.awayTeam = awayTeam.getLongName();
        this.homePlayers = homeTeam.getPlayers();
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }

    public static String getRandomEvent(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public String gameEvent() {
        String[] event = new String[]{"Short Pass","Long Pass","Dribble"};
        return getRandomEvent(event);
    }
    public List<Object> getGameLog() {
        System.out.println(gameLog);
        return gameLog;
    }
    public void addToGameLog() {
        gameLog.add(homePlayers.get(0).playerDetails());
        gameLog.add(gameEvent());
    }
}
