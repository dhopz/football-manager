package example.GameGenerator;

import example.Card;
import example.Goal;
import example.Player;

import java.util.*;

public class GameLog {
    private List<Object> gameLog;
    private List<Player> playerLog;
    private List<Card> cardLog;
    private List<Goal> goalLog;

    public GameLog() {
        this.gameLog = new ArrayList<>();
        this.playerLog = new ArrayList<>();
        this.goalLog = new ArrayList<>();
        this.cardLog = new ArrayList<>();
    }
    public List<Goal> getGoalLog() {
        return goalLog;
    }

    public List<Player> getPlayerLog() {
        return playerLog;
    }

    public void logEvent(String event){
        gameLog.add(event);
    }

    public void displayPlayerLog(){
        List<String> players = new ArrayList<>();
        for (Player player:playerLog){
            players.add(player.playerDetails());
        }
        System.out.println(players);
    }

    public List<Object> getGameLog() {
        System.out.println(gameLog);
        gameLogEvents();
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
//        goalEvents(gameEventCounter);
        System.out.println(gameEventCounter);
        goalScorer(gameLog);
        cardIssued(gameLog);
        getGoalScorer();
        getCardIssued();

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
                goalLog.add(new Goal((String) gameLog.get(i-2),
                        (int) Math.floor((double) i/gameLog.size()*90)));
            }
        }
    }

    public void cardIssued(List<Object> gameLog){
//        String yellow = "Yellow";
        for (int i = 0; i < gameLog.size(); i++) {
            if (Objects.equals(gameLog.get(i), "Yellow")) {
                goalLog.add(new Card((String) gameLog.get(i+1),
                        (int) Math.floor((double) i/gameLog.size()*90),
                        "Yellow"));
            }
            if (Objects.equals(gameLog.get(i), "Red")) {
                goalLog.add(new Card((String) gameLog.get(i+1),
                        (int) Math.floor((double) i/gameLog.size()*90),
                        "Red"));
            }
        }
    }
    public void getGoalScorer(){
        for (Goal goal:goalLog){
            System.out.println(goal.toString());
        }
    }

    public void getCardIssued(){
        for (Card card:cardLog){
            System.out.println(card.toString());
        }
    }
}
