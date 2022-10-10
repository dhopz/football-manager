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

//    @Override public boolean equals(Object obj)
//    {
//
//        // checking if the two objects
//        // pointing to same object
//        if (this == obj)
//            return true;
//
//        // checking for two condition:
//        // 1) object is pointing to null
//        // 2) if the objects belong to
//        // same class or not
//        if (obj == null
//                || this.getClass() != obj.getClass())
//            return false;
//
//        Player p1 = (Player)obj; // type casting object to the
//        // intended class type
//
//        // checking if the two
//        // objects share all the same values
//        return this.firstName.equals(p1.firstName)
//                && Objects.equals(this.lastName, p1.lastName)
//                && this.club.equals(p1.club);
//    }
}
