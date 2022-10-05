package example;

public class App {
    public static void main(String[] args) {
        String[] clubs = {
                "Bournemouth",
                "Arsenal",
                "Aston Villa",
                "Brentford",
                "Brighton",
                "Chelsea",
                "Crystal Palace",
                "Everton",
                "Fulham",
                "Leeds",
                "Leicester City",
                "Liverpool",
                "Man City",
                "Man United",
                "Newcastle",
                "Nottingham",
                "Southampton",
                "Tottenham",
                "West Ham",
                "Wolves"
        };
        League league = new League("New League","New Country",clubs);
        league.generateSeason();

        System.out.println("\n " + league.getChampion() + " League Champion \n");

    }
}


