package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Engine {
    private final String homeTeam;
    private final String awayTeam;
    private String kickOffTeam;
    private String attackingTeam;
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

    public void teamToKickOff(){
        String[] teams = new String[]{homeTeam,awayTeam};
        kickOffTeam = RandomGenerator.getRandomEvent(teams);
    }

    public String teamEvent() {
        String[] teamPlay = new String[]{
                "Pass",
                "Through Ball",
                "Long Pass",
                "Dribble",
                "Backwards Pass",
//                "Cross",
//                "Corner"
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
//                "Foul"
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

    public void gameStart(){
        teamToKickOff();
        gameLog.add(kickOffTeam);
        gameLog.add(playerReceive(kickOffTeam).playerDetails());
        gameLog.add("Pass");
        gameLog.add(playerReceive(kickOffTeam).playerDetails());
        attackingTeam = kickOffTeam;
    }
    public void addToGameLog() {
        gameStart();
        constructPlay();
    }

//    public boolean playerReceiveSuccess(){
//        if(teamToKickOff()==homeTeam){
//            playerReceive(homeTeam)
//        }
//    }

    public void constructPlay(){
        for (int i = 1; i < 5; i++) {
            teamEventPlay();
        }
    }

    public void teamEventPlay(){
        String teamPlay = teamEvent();
        if (Objects.equals(teamPlay, "Pass") || "Long Pass".equals(teamPlay) || "Backwards Pass".equals(teamPlay) ){
            gameLog.add(teamPlay);
            if (dribbleEvent()){
                gameLog.add(teamEvent());
            }
            gameLog.add(playerReceive(attackingTeam).playerDetails());
        } else {
            gameLog.add(defendInPlayEvent());
            attackTeamSwitch();
            gameLog.add(playerReceive(attackingTeam).playerDetails());
        }
    }

    public void attackTeamSwitch(){
        Player player;
        if (Objects.equals(attackingTeam, homeTeam)){
            player = RandomGenerator.getRandomPlayer(awayPlayers);
        } else {
            player = RandomGenerator.getRandomPlayer(homePlayers);
        }
        attackingTeam = player.getClub();
    }

    public Player playerReceive(String team){
        if (Objects.equals(team, homeTeam)){
            return RandomGenerator.getRandomPlayer(homePlayers);
        } else {
            return RandomGenerator.getRandomPlayer(awayPlayers);
        }
    }

    public String playerDefend(){
        return RandomGenerator.getRandomPlayerName(awayPlayers);
    }

    public boolean dribbleEvent(){
        return gameLog.get(gameLog.size()-1)=="Dribble";
    }

//    public String playerPass(){
//        Object previousPlayer = gameLog.get(gameLog.size()-1);
//        if (previousPlayer.getClass() == Player){
//
//        }
//    }

}
