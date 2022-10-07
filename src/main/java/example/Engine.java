package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Engine {
    private final String homeTeam;
    private final String awayTeam;
    private List<Object> gameLog = new ArrayList<>();
    private final List<Player> homePlayers;
    private final List<Player> awayPlayers;
    public Engine(Team homeTeam, Team awayTeam) {
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

    public String teamEvent() {
        String[] teamPlay = new String[]{
                "Pass",
                "Through Ball",
                "Long Pass",
                "Dribble",
                "Backwards Pass",
                "Cross",
                "Corner"
        };
        return RandomGenerator.getRandomEvent(teamPlay);
    }
    public String defenceEvent() {
        String[] defencePlay = new String[]{
                "Block",
                "Interception",
                "Tackle",
                "Last Man Tackle",
                "Clearance",
                "Headed Clearance",
                "Opponent Offside",
                "Own Goal",
                "Penalty Conceded",
                "Foul"
        };
        return RandomGenerator.getRandomEvent(defencePlay);
    }
    public String defendInPlayEvent(){
        String[] defencePlay = new String[]{
                "Interception",
                "Tackle",
                "Foul"
        };
        return RandomGenerator.getRandomEvent(defencePlay);
    }
    public String keeperEvent(){
        String[] keeperPlay = new String[]{
                "Save",
                "Tackle",
                "Clearance",
                "Penalty Conceded"
        };
        return RandomGenerator.getRandomEvent(keeperPlay);
    }

    public String attackEvent(){
        String[] attackPlay = new String[]{
                "Shot",
                "On Target",
                "Hit Woodwork",
                "Goal from Header",
                "Goal from Penalty",
                "Goal from Free kick",
                "Goal from Inside Box",
                "Goal from Outside Box",
                "Goals from Counter Attack",
                "Offside"
        };
        return RandomGenerator.getRandomEvent(attackPlay);

    }
    public List<Object> getGameLog() {
        System.out.println(gameLog);
        return gameLog;
    }
    public void addToGameLog() {
        gameLog.add(teamToKickOff());
        gameLog.add(getPlayer());
        teamEventPlay();
    }
    public String getPlayer(){
        if (gameLog.get(1) == homeTeam){
            return homePlayers.get(0).playerDetails();
        } else {
            return awayPlayers.get(0).playerDetails();
        }
    }

    public void teamEventPlay(){
        String teamPlay = teamEvent();
        if (Objects.equals(teamPlay, "Pass") || "Long Pass".equals(teamPlay) || "Backwards Pass".equals(teamPlay) ){
            gameLog.add(teamEvent());
            gameLog.add(getPlayer());
        } else {
            gameLog.add(defendInPlayEvent());
            defendInPlayEvent();
        }
    }

}
