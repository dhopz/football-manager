package example;

import java.util.List;

public class Table extends Results{

    private String team;
    private Integer played;
    private Integer won;
    private Integer drawn;
    private Integer lost;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer goalDifference;
    private Integer points;
    private List<Character> lastFive;


    private Integer rank;

    public Table(String team, Integer played, Integer won, Integer drawn, Integer lost, Integer goalsFor,
            Integer goalsAgainst, Integer goalDifference, Integer points, List<Character> lastFive) {
        super(team, played, won, drawn, lost, goalsFor, goalsAgainst, goalDifference, points);
        //TODO Auto-generated constructor stub
        this.team = team;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
        this.lastFive = lastFive;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }


    public Integer getPlayed() {
        return played;
    }


    public Integer getWon() {
        return won;
    }


    public Integer getDrawn() {
        return drawn;
    }


    public Integer getLost() {
        return lost;
    }


    public Integer getGoalsFor() {
        return goalsFor;
    }


    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }


    public Integer getGoalDifference() {
        return goalDifference;
    }


    public Integer getPoints() {
        return points;
    }


    public List<Character> getLastFive() {
        return lastFive;
    }

    @Override
    public String toString(){               
        return String.format(" Rank=%s Team=%s Played=%d won=%d drawn=%d lost=%d goalsFor=%d goalsAgainst=%d goalDifference=%d points=%d lastFive=%s",
                rank,
                team,
                played,
                won,
                drawn,
                lost,
                goalsFor,
                goalsAgainst,
                goalDifference,
                points,
                lastFive.subList(lastFive.size() - 5, lastFive.size()));

    }
    
}
