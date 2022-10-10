import example.GameGenerator.Engine;
import example.GameGenerator.GamePlay;
import example.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GamePlayTest {
    Team chelsea;
    Team arsenal;
    Engine engine;
    GamePlay gamePlay;


    @BeforeEach
    public void createTeamAndAction(){
//        randomGenerator = mock(RandomGenerator.class);
        chelsea = new Team("CHE","Chelsea");
        arsenal = new Team("ARS","Arsenal");
        String[] player = new String[]{"Thiago Silva","Defender","Chelsea"};
        String[] player2 = new String[]{"Reece James","Defender","Chelsea"};
        String[] player3 = new String[]{"Mateo Kovavic","Midfielder","Chelsea"};
        String[] player4 = new String[]{"Kai Havertz","Forward","Chelsea"};
        List<String[]> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        chelsea.createPlayers(players);

        String[] player7 = new String[]{"Ben White","Defender","Arsenal"};
        String[] player5 = new String[]{"Rob Holding","Defender","Arsenal"};
        String[] player6 = new String[]{"Thomas Partey","Midfielder","Arsenal"};
        String[] player8 = new String[]{"Gabriel Jesus","Forward","Arsenal"};
        List<String[]> arsenalPlayers = new ArrayList<>();
        arsenalPlayers.add(player7);
        arsenalPlayers.add(player5);
        arsenalPlayers.add(player6);
        arsenalPlayers.add(player8);
        arsenal.createPlayers(arsenalPlayers);

        gamePlay = new GamePlay(chelsea,arsenal);
    }

    @Test
    void GivenTeams_AGameIsGenerated_AndSavedInTheGameLog(){
        gamePlay.constructPlay();
        assertEquals(8, gamePlay.getGameLog().size());
    }
}
