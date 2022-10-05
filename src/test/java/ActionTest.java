import example.Action;
import example.Team;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActionTest {
    @Test
    void GivenTwoTeams_GetHomeTeamAndAwayTeam(){
        Team chelsea = new Team("CHE","Chelsea");
        Team arsenal = new Team("ARS","Arsenal");

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

        Action action = new Action(chelsea,arsenal);

        assertEquals("Chelsea",action.getHomeTeam());
        assertEquals("Arsenal",action.getAwayTeam());
    }
}
