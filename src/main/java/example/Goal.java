package example;

public class Goal {
    private final String playerName;

    private final int goalNumber;

    private double timeScored;


    public Goal(String playerName, int timeScored) {
        this.playerName = playerName;
        this.goalNumber = 1;
        this.timeScored = timeScored;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getGoal() {
        return goalNumber;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "playerName='" + playerName + '\'' +
                ", timeScored=" + timeScored +
                '}';
    }

    protected double getTimeScored() {
        return timeScored;
    }

    public void setTimeScored(double timeScored) {
        this.timeScored = timeScored;
    }
}
