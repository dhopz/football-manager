package example;

public class Goal {
    private final String playerName;

    private final int goalNumber;

    public Goal(String playerName) {
        this.playerName = playerName;
        this.goalNumber = 1;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getGoal() {
        return goalNumber;
    }

}
