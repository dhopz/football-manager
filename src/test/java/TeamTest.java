import example.Player;
import example.Team;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TeamTest {
    @Test
    void GivenATeam_WhenStringsAreProvided_createATeam(){
        Team team = new Team("CHE","Chelsea");
        assertEquals("Chelsea",team.getLongName());
        assertEquals("CHE",team.getShortName());
    }

    @Test
    void GivenATeam_WhenThereIsAPlayer_FindPlayerInList(){
        Team team = new Team("ARS","Arsenal");
        Player player = new Player("Thiago","Silva","Defender","Chelsea");
        team.addPlayer(player);
        assertEquals(1,team.getPlayers().size());
    }
    @Test
    void GivenATeam_CreateAnotherPlayer_FindPlayerInList(){
        Team team = new Team("ARS","Arsenal");
        Player player = new Player("Thiago","Silva","Defender","Chelsea");
        Player player1 = new Player("Reece","James","Defender","Chelsea");
        team.addPlayer(player);
        team.addPlayer(player1);
        assertEquals(2,team.getPlayers().size());
        assertEquals("Reece James",team.getPlayers().get(1).playerDetails());
    }

    @Test
    void GivenATeam_CreateAPlayer_WhenGivenAListOfPlayers(){
        Team team = new Team("CHE","Chelsea");
        String[] player = new String[]{"Thiago Silva","Defender","Chelsea"};
        String[] player2 = new String[]{"Reece James","Defender","Chelsea"};
        List<String[]> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        team.createPlayers(players);
        assertEquals("Reece James",team.getPlayers().get(1).playerDetails());
    }

}
