package example;

public class Card extends Goal{

    String cardType;

    public Card(String playerName, int timeScored, String cardType) {
        super(playerName, timeScored);
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
//        String playerName = this.getPlayerName();
//        double timeScored = this.getTimeScored();
        return "Card{" +
                "PlayerName='" + this.getPlayerName() + '\'' +
                "cardType='" + cardType + '\'' +
                "time='" + this.getTimeScored() + '\'' +
                '}';
    }


}
