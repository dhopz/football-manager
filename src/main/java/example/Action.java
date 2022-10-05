package example;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

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

    public String gameEvent() {
        return "Short Pass";
    }
    public List<Object> getGameLog() {
        return gameLog;
    }
    public void addToGameLog() {
        gameLog.add(homePlayers.get(0).playerDetails());
        gameLog.add(gameEvent());
    }
}
