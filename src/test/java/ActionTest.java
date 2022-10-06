import example.Action;
import example.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionTest {
    Team chelsea;
    Team arsenal;
    Action action;

//    @Mock
//    RandomGenerator randomGenerator;


    @BeforeEach
    public void createTeamAndAction(){
//        randomGenerator = mock(RandomGenerator.class);
        chelsea = new Team("CHE","Chelsea");
        arsenal = new Team("ARS","Arsenal");
        String[] player = new String[]{"Thiago Silva","Defender","Chelsea"};
        String[] player2 = new String[]{"Reece James","Defender","Chelsea"};
        List<String[]> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        chelsea.createPlayers(players);

        String[] player3 = new String[]{"Ben White","Defender","Arsenal"};
        String[] player4 = new String[]{"Rob Holding","Defender","Arsenal"};
        List<String[]> arsenalPlayers = new ArrayList<>();
        arsenalPlayers.add(player3);
        arsenalPlayers.add(player4);
        arsenal.createPlayers(arsenalPlayers);
        action = new Action(chelsea,arsenal);
    }

    @Test
    void whenAGameIsCreated_KickOffIsRecordedInTheGameLog(){
        assertEquals("Kick Off",action.getGameLog().get(0));
    }
    @Test
    void GivenTwoTeams_GetHomeTeamAndAwayTeam(){
        assertEquals("Chelsea",action.getHomeTeam());
        assertEquals("Arsenal",action.getAwayTeam());
    }
//    @Test
//    void GivenTwoTeams_GetPlayers(){
//        assertEquals("Short Pass",action.gameEvent());
//    }
    @Test
    void GivenTeams_AnActionIsCompleted_AndSavedInTheGameLog(){
        action.addToGameLog();
        assertEquals(4, action.getGameLog().size());
    }
//    @Test
//    void GivenTeams_ALongPassActionIsCompleted_AndSavedInTheGameLog(){
//        action.addToGameLog();
//        assertEquals("Short Pass", action.getGameLog().get(1));
//    }
    @Test
    void GivenTeams_PlayerAppearsInGameLog(){
        action.addToGameLog();
        assertEquals("Thiago Silva",action.getGameLog().get(2));
    }

    @Test
    void GivenTeams_AssignATeamToKickOff(){
        action.addToGameLog();
        assertEquals("Chelsea",action.getGameLog().get(1));
    }
//    @Test
//    void GivenAGameKickOff_WhenTeamIsSelected_ThenThePlayerShouldBeFromThatTeam(){
//        action.addToGameLog();
//        assertEquals();
//
//    }
}
