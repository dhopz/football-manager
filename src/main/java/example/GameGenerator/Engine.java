package example.GameGenerator;

import example.Player;
import example.RandomGenerator;
import example.Team;

import java.util.List;
import java.util.Objects;


public class Engine {
    private final String homeTeam;
    private final String awayTeam;
    private String kickOffTeam;

    private String attackingTeam;
    private final List<Player> homePlayers;
    private final List<Player> awayPlayers;
    public Engine(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam.getLongName();
        this.awayTeam = awayTeam.getLongName();
        this.homePlayers = homeTeam.getPlayers();
        this.awayPlayers = awayTeam.getPlayers();
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }

    public Player checkPlayer(List<Player> playerLog) {
        Player lastPlayer = playerLog.get(playerLog.size() - 1);
        Player player;
        do {
            player = playerSelect(attackingTeam);
        } while (Objects.equals(lastPlayer.playerDetails(), player.playerDetails()));
        return player;
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

    public Player playerSelect(String team){
        if (Objects.equals(team, homeTeam)){
            return RandomGenerator.getRandomPlayer(homePlayers);
        } else {
            return RandomGenerator.getRandomPlayer(awayPlayers);
        }
    }

    public void setAttackingTeam(String attackingTeam) {
        this.attackingTeam = attackingTeam;
    }

    public boolean checkForwardPlayer(List<Player> playerLog){
        return Objects.equals(playerLog.get(playerLog.size() - 1).getPosition(), "Forward");
    }

    public boolean checkMidfieldPlayer(List<Player> playerLog){
        return Objects.equals(playerLog.get(playerLog.size() - 1).getPosition(), "Midfielder");
    }

}
