package example;

import java.util.ArrayList;
import java.util.List;


public class Action {
    private final String homeTeam;
    private final String awayTeam;
    private List<Object> gameLog = new ArrayList<>();
    private final List<Player> homePlayers;
    private final List<Player> awayPlayers;
    public Action(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam.getLongName();
        this.awayTeam = awayTeam.getLongName();
        this.homePlayers = homeTeam.getPlayers();
        this.awayPlayers = awayTeam.getPlayers();
        this.gameLog.add("Kick Off");
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }

    public String teamToKickOff(){
        String[] teams = new String[]{homeTeam,awayTeam};
        return RandomGenerator.getRandomEvent(teams);
    }

    public String gameEvent() {
        String[] event = new String[]{"Short Pass","Long Pass","Dribble"};
        return RandomGenerator.getRandomEvent(event);
    }
    public List<Object> getGameLog() {
        System.out.println(gameLog);
        return gameLog;
    }
    public void addToGameLog() {
        gameLog.add(teamToKickOff());
        gameLog.add(getPlayer());
        gameLog.add(gameEvent());
    }
    public String getPlayer(){
        if (gameLog.get(1) == homeTeam){
            return homePlayers.get(0).playerDetails();
        } else {
            return awayPlayers.get(0).playerDetails();
        }
    }

}
