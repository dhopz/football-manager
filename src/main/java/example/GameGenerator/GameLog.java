package example.GameGenerator;

import example.Goal;
import example.Player;

import java.util.*;

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
        gameLogEvents();
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

    public void gameLogEvents(){
        Map<Object,Integer> gameEventCounter = new HashMap<>();
        for (Object event:gameLog){
            if(!gameEventCounter.containsKey(event)){
                gameEventCounter.put(event,1);
            } else {
                gameEventCounter.put(event,gameEventCounter.get(event)+1);
            }
        }
        goalEvents(gameEventCounter);
        System.out.println(gameEventCounter);
        goalScorer(gameLog);

    }

    public void goalEvents(Map<Object,Integer> gameEventCounter){
        if (gameEventCounter.containsKey("GOAL!!")){
            System.out.println("Goals = " + gameEventCounter.get("GOAL!!"));
        } else {
            System.out.println("No Goals");
        }
    }

    public void goalScorer(List<Object> gameLog){
        String item = "GOAL!!";
        for (int i = 0; i < gameLog.size(); i++) {
            if (Objects.equals(gameLog.get(i), item)) {
                new Goal((String) gameLog.get(i-2));
            }
        }
    }
}
