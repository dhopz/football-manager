package example;

import java.util.*;

public class League {

    private final String name;
    private final String country;
    private final String[] clubs;
    private final List<Games> footballGames = new ArrayList<>();
    private final List<Results> footballResults = new ArrayList<>();
    private final List<Table> footballTable = new ArrayList<>();

    public League(String league, String country, String[] clubs){
        this.name = league;
        this.country = country;
        this.clubs = clubs;
    }

    public List<Games> getFootballGames() {
        return footballGames;
    }
    public List<Results> getFootballResults() {
        return footballResults;
    }
    public List<Table> getFootballTable() {
        return footballTable;
    }
    public static Integer randomInt(){
        Random r = new Random();
        return r.nextInt(5);
    }

    public List<Games> createGames(){
        int i = 0;
        for (String homeTeam: clubs){
            for (String awayTeam: clubs){
                if(Objects.equals(homeTeam, awayTeam)) continue;
                footballGames.add(new Games(i, homeTeam, awayTeam, randomInt(), randomInt(), randomInt(), randomInt()));
                i++;
            }
        }
        return this.footballGames;
    }

   public List<Results> createResults(){
       int won;
       int drawn;
       int points;
       int lost;

       for (Games game: createGames()){
           if(game.getStats().getHomeGoals() > game.getStats().getAwayGoals()){
               won = 1;
               drawn = 0;
               lost = 0;
               points = 3;
           } else if(game.getStats().getHomeGoals() < game.getStats().getAwayGoals()){
               won = 0;
               drawn = 0;
               lost = 1;
               points = 0;
           } else {
               won = 0;
               drawn = 1;
               lost = 0;
               points = 1;
           }

           footballResults.add(new Results(game.getHomeTeam(), 1, won, drawn, lost, game.getStats().getHomeGoals(), game.getStats().getAwayGoals(), game.getStats().getHomeGoals() - game.getStats().getAwayGoals(), points));
           footballResults.add(new Results(game.getAwayTeam(), 1, won, drawn, lost, game.getStats().getAwayGoals(), game.getStats().getHomeGoals(), game.getStats().getAwayGoals() - game.getStats().getHomeGoals(), points));
       }
       return this.footballResults;
   }
   public void generateTable(){
        //Have to create the results
        createResults();
       for (String club:this.clubs){

           int played = 0;
           int won = 0;
           int drawn= 0;
           int lost= 0;
           int goalsFor= 0;
           int goalsAgainst= 0;
           int goalDifference= 0;
           int points= 0;
           ArrayList<Character> lastFive = new ArrayList<>();

           for (Results result: this.footballResults){

               if(Objects.equals(result.getTeam(), club)){
                   points = points + result.getPoints();
                   played = played + result.getPlayed();
                   won = won + result.getWon();
                   drawn= drawn + result.getDrawn();
                   lost= lost + result.getLost();
                   goalsFor= goalsFor + result.getGoalsFor();
                   goalsAgainst= goalsAgainst + result.getGoalsAgainst();
                   goalDifference= goalDifference + result.getGoalDifference();
                   lastFive.add(addResult(result));
               }
           }
           footballTable.add(new Table(club, played, won, drawn, lost, goalsFor, goalsAgainst, goalDifference, points, lastFive));
       }
   }

   public char addResult(Results result){
       if (result.getWon() == 1){
           return 'W';
       }
       else if (result.getLost()== 1){
           return 'L';
       }
       else {
           return 'D';
       }
   }

   public void generateRank(){
       Integer i = 1;
       for (Table clubResults: this.footballTable){
           clubResults.setRank(i);
           i++;
       }
   }

   public void printResults(){
       for (Table clubResults: this.footballTable){
           System.out.println(clubResults);
       }
   }

   public void generateSeason(){
        generateTable();
        footballTable.sort(new FootballTableSortingComparator());
        Collections.reverse(footballTable);
        generateRank();
        printResults();
   }

   public String getChampion(){
       return footballTable.get(0).getTeam();
   }

   public void getGameResults(String team){
       for (Games games: footballGames){
           if (Objects.equals(games.getHomeTeam(),team) || Objects.equals(games.getAwayTeam(),team)){
               System.out.println(games.getMatchData());
           }
       }
   }

   public void getTeamResults(String team){
       for(Results result: footballResults){
           if(Objects.equals(result.getTeam(), team)){
               System.out.println(result.resultEntry());
           }
       }
   }

    @Override
    public String toString() {
        return "Leagues{" +
                "league='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}