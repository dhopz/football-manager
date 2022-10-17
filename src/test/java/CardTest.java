import example.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    @Test
    void createCard(){
        Card card = new Card("Bakary Saka",10, "Red");
        assertEquals("Red", card.getCardType());
        assertEquals("Bakary Saka", card.getPlayerName());
    }
}
