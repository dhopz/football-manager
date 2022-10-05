import example.Games;
import example.League;
import example.Results;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LeagueTest {
    @Test
    void toStringLeagueNameStringCountryStringNewLeagueCreatedReturnString(){
        String[] clubs = new String[]{"Bournemouth","Arsenal"};
        League league = new League("New League","New Country",clubs);
        assertEquals("Leagues{league='New League', country='New Country'}", league.toString());
    }
    @Test
    void createGamesInputClubsArrayReturn2Teams2Matches(){
        String[] clubs = new String[]{"Bournemouth","Arsenal"};
        League league = new League("New League","New Country",clubs);
        List<Games> newGames = league.createGames();

        assertEquals(2,newGames.size());
        assertEquals("Bournemouth",newGames.get(0).getHomeTeam());
        assertEquals("Arsenal",newGames.get(0).getAwayTeam());
        assertEquals("Arsenal",newGames.get(1).getHomeTeam());
        assertEquals("Bournemouth",newGames.get(1).getAwayTeam());
        assertNotNull(newGames.get(0).getStats().getHomeGoals());
    }

    @Test
    void createGamesInput3ClubsArrayReturn3Teams6Matches(){
        String[] clubs = new String[]{"Bournemouth","Arsenal","Chelsea"};
        League league = new League("New League", "New Country",clubs);
        List<Games> newGames = league.createGames();
        assertEquals(6,newGames.size());
        assertEquals("Bournemouth",newGames.get(0).getHomeTeam());
        assertEquals("Arsenal",newGames.get(0).getAwayTeam());
        assertEquals("Bournemouth",newGames.get(1).getHomeTeam());
        assertEquals("Chelsea",newGames.get(1).getAwayTeam());
        assertEquals("Arsenal",newGames.get(2).getHomeTeam());
        assertEquals("Bournemouth",newGames.get(2).getAwayTeam());
        assertEquals("Arsenal",newGames.get(3).getHomeTeam());
        assertEquals("Chelsea",newGames.get(3).getAwayTeam());
        assertNotNull(newGames.get(0).getStats().getHomeGoals());
    }

    @Test
    void createGamesInput20ClubsReturn380Matches(){
        String[] clubs = new String[]{
                "Bournemouth",
                "Arsenal",
                "Aston Villa",
                "Brentford",
                "Brighton",
                "Chelsea",
                "Crystal Palace",
                "Everton",
                "Fulham",
                "Leeds",
                "Leicester City",
                "Liverpool",
                "Man City",
                "Man United",
                "Newcastle",
                "Nottingham",
                "Southampton",
                "Tottenham",
                "West Ham",
                "Wolves"};
        League league = new League("New League","New Country",clubs);
        List<Games> newGames = league.createGames();
        assertEquals(380,newGames.size());
    }

    @Test
    void createResults2ClubsReturnPointsFromGame(){
        String[] clubs = new String[]{"Bournemouth","Arsenal"};
        League league = new League("New League","New Country",clubs);
        List<Results> results = league.createResults();
        assertEquals("Bournemouth",results.get(0).getTeam());
        assertEquals(Integer.valueOf(1),results.get(0).getPlayed());
        assertEquals("Arsenal",results.get(1).getTeam());
        assertEquals(Integer.valueOf(1),results.get(1).getPlayed());
        assertEquals(4,results.size());
    }

//    @Test
//    public void createTable2ClubsReturnPositionOfClub(){
//        String[] clubs = new String[]{"Bournemouth","Arsenal"};
//        Leagues league = new Leagues("New League","New Country",clubs);
//        List<Table> table = league.generateTable();
//        assertEquals(Integer.valueOf(1),table.get(0).getPosition());
//    }


}
