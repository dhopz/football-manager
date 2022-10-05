package example;

import java.util.HashMap;
import java.util.Map;

public class Results {
    private final String team;
    private final Integer played;
    private final Integer won;
    private final Integer drawn;
    private final Integer lost;
    private final Integer goalsFor;
    private final Integer goalsAgainst;
    private final Integer goalDifference;
    private final Integer points;
    

    public Results(
        String team,
        Integer played,
        Integer won,
        Integer drawn,
        Integer lost,
        Integer goalsFor,
        Integer goalsAgainst,
        Integer goalDifference,
        Integer points
        )
        {
        this.team = team;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
       
        // {team=Chelsea, played=38,won=x,drawn=x,lost=x,GF=x,GA=x,GD=x,points=x}
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


    public Map<String,Object> resultEntry(){
        HashMap<String, Object> results = new HashMap<>();
        results.put("team",this.team);
        results.put("played",this.played);
        results.put("won",this.won);
        results.put("drawn",this.drawn);
        results.put("lost",this.lost);
        results.put("goalsFor",this.goalsFor);
        results.put("goalsAgainst",this.goalsAgainst);
        results.put("goalDifference",this.goalDifference);
        results.put("points",this.points);

        return results;
    }

}