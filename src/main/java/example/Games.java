package example;

import java.util.HashMap;
import java.util.Map;

public class Games {
    private final Integer id;
    private final String homeTeam;
    private final String awayTeam;
    private final Stats stats;

    public Games(
        Integer id, 
        String homeTeam, 
        String awayTeam,
        Integer homeGoals,
        Integer awayGoals,
        Integer redCards,
        Integer yellowCards
        )
        {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stats = new Stats(
            id, 
            homeGoals, 
            awayGoals, 
            redCards, 
            yellowCards);
    }

    public Map<String, String> getMatchData() {
        HashMap<String, String> stringData = new HashMap<>();
        stringData.put("homeTeam",this.homeTeam);
        stringData.put("awayTeam",this.awayTeam);
        
        Map<String,String> resultData = stats.gameResults();

        stringData.putAll(resultData);
        
        return stringData;
    }

    public Integer getId() {
        return id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Stats getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "Games{" +
                "id=" + id +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                '}';
    }
}
  