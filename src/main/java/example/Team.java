package example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String shortName;
    private final String longName;
    private List<Player> players = new ArrayList<>();

    public Team(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public List<Player> getPlayers(){
        //return a ArrayList
        //Function to get the players for the team
        return players;
    }
    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void createPlayers(List<String[]> players) {
        for(String[] player:players){
            String firstName = player[0].split(" ")[0];
            String lastName = player[0].split(" ")[1];
            this.addPlayer(new Player(firstName, lastName,player[1],player[2]));
        }

    }
}
