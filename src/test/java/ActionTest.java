import example.Action;
import example.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionTest {
    Team chelsea;
    Team arsenal;
    Action action;

    @BeforeEach
    public void createTeamAndAction(){
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
        players.add(player3);
        players.add(player4);
        arsenal.createPlayers(arsenalPlayers);
        action = new Action(chelsea,arsenal);
    }
    @Test
    void GivenTwoTeams_GetHomeTeamAndAwayTeam(){
        assertEquals("Chelsea",action.getHomeTeam());
        assertEquals("Arsenal",action.getAwayTeam());
    }
    @Test
    void GivenTwoTeams_GetPlayers(){
        assertEquals("Short Pass",action.gameEvent());
    }
    @Test
    void GivenTeams_AnActionIsCompleted_AndSavedInTheGameLog(){
        action.addToGameLog();
        assertEquals("Short Pass", action.getGameLog().get(1));
    }
    @Test
    void GivenTeams_ALongPassActionIsCompleted_AndSavedInTheGameLog(){
        action.addToGameLog();
        assertEquals("Long Pass", action.getGameLog().get(1));
    }
    @Test
    void GivenTeams_PlayerAppearsInGameLog(){
        action.addToGameLog();
        assertEquals("Thiago Silva",action.getGameLog().get(0));
    }
}
