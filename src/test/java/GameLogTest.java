import example.GameGenerator.GameLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameLogTest {
    @Test
    void GivenAGoal_ReturnListOfGoalScorers(){
        GameLog log = new GameLog();
        assertEquals("Kai Havertz",log.getGoalLog().get(0).getPlayerName());
    }
}
