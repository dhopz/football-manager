package example;

public class Player {
    private final String firstName;
    private final String lastName;
    private String position;
    private String club;

    public Player(String firstName, String lastName, String position,String club){
        this.firstName = firstName;
        this.lastName =lastName;
        this.position = position;
        this.club = club;
    }

    public String playerDetails(){
        return this.firstName + " " + this.lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
