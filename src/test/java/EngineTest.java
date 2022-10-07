import example.Engine;
import example.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EngineTest {
    Team chelsea;
    Team arsenal;
    Engine engine;

//    @Mock
//    RandomGenerator randomGenerator;


    @BeforeEach
    public void createTeamAndAction(){
//        randomGenerator = mock(RandomGenerator.class);
        chelsea = new Team("CHE","Chelsea");
        arsenal = new Team("ARS","Arsenal");
        String[] player = new String[]{"Thiago Silva","Defender","Chelsea"};
        String[] player2 = new String[]{"Reece James","Defender","Chelsea"};
        String[] player3 = new String[]{"Mateo Kovavic ","Midfielder","Chelsea"};
        List<String[]> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        players.add(player3);
        chelsea.createPlayers(players);

        String[] player4 = new String[]{"Ben White","Defender","Arsenal"};
        String[] player5 = new String[]{"Rob Holding","Defender","Arsenal"};
        String[] player6 = new String[]{"Thomas Partey","Midfielder","Arsenal"};
        List<String[]> arsenalPlayers = new ArrayList<>();
        arsenalPlayers.add(player4);
        arsenalPlayers.add(player5);
        arsenalPlayers.add(player6);
        arsenal.createPlayers(arsenalPlayers);
        engine = new Engine(chelsea,arsenal);
    }

    @Test
    void whenAGameIsCreated_KickOffIsRecordedInTheGameLog(){
        assertEquals("Kick Off", engine.getGameLog().get(0));
    }
    @Test
    void GivenTwoTeams_GetHomeTeamAndAwayTeam(){
        assertEquals("Chelsea", engine.getHomeTeam());
        assertEquals("Arsenal", engine.getAwayTeam());
    }
//    @Test
//    void GivenTwoTeams_GetPlayers(){
//        assertEquals("Short Pass",action.gameEvent());
//    }
    @Test
    void GivenTeams_AnActionIsCompleted_AndSavedInTheGameLog(){
        engine.addToGameLog();
        assertEquals(8, engine.getGameLog().size());
    }
//    @Test
//    void GivenTeams_ALongPassActionIsCompleted_AndSavedInTheGameLog(){
//        action.addToGameLog();
//        assertEquals("Short Pass", action.getGameLog().get(1));
//    }
    @Test
    void GivenTeams_PlayerAppearsInGameLog(){
        engine.addToGameLog();
        assertEquals("Thiago Silva", engine.getGameLog().get(2));
    }

    @Test
    void GivenTeams_AssignATeamToKickOff(){
        engine.addToGameLog();
        assertEquals("Chelsea", engine.getGameLog().get(1));
    }
//    @Test
//    void GivenAGameKickOff_WhenTeamIsSelected_ThenThePlayerShouldBeFromThatTeam(){
//        action.addToGameLog();
//        assertEquals();
//
//    }
}
