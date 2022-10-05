//import org.junit.jupiter.api.Test;

import example.Games;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GamesTest {
    @Test
    void toStringGameDataCreateNewGameReturnString(){
        Games game = new Games(1,"Home Team","Away Team",1,2,1,1);
        assertEquals("Games{id=1, homeTeam='Home Team', awayTeam='Away Team'}",game.toString());
    }

    @Test
    void getMatchDataNoInputReturnsMapOfGameData(){
        Games game = new Games(1,"HomeTeam","AwayTeam",1,2,1,1);
        HashMap<String,String> gameData = new HashMap<>();
        gameData.put("gameId", game.getId().toString());
        gameData.put("awayTeam","AwayTeam");
        gameData.put("homeTeam","HomeTeam");
        gameData.put("homeGoals","1");
        gameData.put("awayGoals","2");
        gameData.put("redCards","1");
        gameData.put("yellowCards","1");
//        {gameId=14, awayTeam=AwayTeam, homeTeam=HomeTeam, homeGoals=3, yellowCards=1, awayGoals=2, redCards=2}
        assertEquals(gameData,game.getMatchData());
    }

//    @Test
//    public void createAGame_GivenTwoTeams(){
//        Team team = new Team("ARS","Arsenal");
//        Team team1 = new Team("CHE","Chelsea");
//        Player player = new Player("Thiago","Silva","Defender","Chelsea");
//        team.addPlayer(player);
//        assertEquals(11,team.getPlayers());
//    }

}
