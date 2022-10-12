package example.GameGenerator;

import example.Player;

import java.util.ArrayList;
import java.util.List;

public class GameLog {
    private List<Object> gameLog;
    private List<Player> playerLog;

    public GameLog() {
        this.gameLog = new ArrayList<>();
        this.playerLog = new ArrayList<>();
    }

    public List<Player> getPlayerLog() {
        return playerLog;
    }

    public void logEvent(String event){
        gameLog.add(event);
    }

    public void addPlayer(Player player){
        playerLog.add(player);
    }

    public List<Object> getGameLog() {
        System.out.println(gameLog);
        List<String> players = new ArrayList<>();
        for (Player player:playerLog){
            players.add(player.playerDetails());
        }
        System.out.println(players);
        return gameLog;
    }
    public void logPlayEvent(Player player){
        gameLog.add(player.playerDetails());
        playerLog.add(player);
    }
    public boolean checkPlayerDribble(){
        return gameLog.get(gameLog.size()-1)=="Dribble";
    }
}
