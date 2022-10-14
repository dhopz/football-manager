import example.Goal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoalTest {

    @Test
    void createGoal(){
        Goal goal = new Goal("Bakary Saka",10);
        assertEquals(1, goal.getGoal());
        assertEquals("Bakary Saka", goal.getPlayerName());
    }
}
