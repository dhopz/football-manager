package example.GameGenerator;

import example.Card;
import example.RandomGenerator;
import example.Team;

import java.util.List;
import java.util.Objects;

public class GamePlay {
    private final String homeTeam;
    private final String awayTeam;
    private String kickOffTeam;
    private String attackingTeam;
    GameEvent gameEvent;
    GameLog gameLog;
    Engine engine;

    public List<Object> getGameLog() {
        return gameLog.getGameLog();
    }

    public GamePlay(Team homeTeam, Team awayTeam) {
        this.gameEvent = new GameEvent();
        this.gameLog = new GameLog();
        this.homeTeam = homeTeam.getLongName();
        this.awayTeam = awayTeam.getLongName();
        this.engine = new Engine(homeTeam, awayTeam);

    }

    public void constructPlay(){
        gameStart();
        for (int i = 1; i < 50; i++) {
            if (engine.checkMidfieldPlayer(gameLog.getPlayerLog())){
                midfieldPlayerEventPicker();
            }
            teamEventPlay();
            if (engine.checkForwardPlayer(gameLog.getPlayerLog())){
                attackingPlayerEventPicker();
            }
        }
    }
    public void teamToKickOff(){
        String[] teams = new String[]{homeTeam,awayTeam};
        kickOffTeam = RandomGenerator.getRandomEvent(teams);
    }

    public void gameStart(){
        teamToKickOff();
        gameLog.logEvent(kickOffTeam);
        attackingTeam = kickOffTeam;
        engine.setAttackingTeam(kickOffTeam);
        gameLog.logPlayEvent(engine.playerSelect(kickOffTeam));
        gameLog.logEvent("Pass");
        gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
    }

    public void playStart(){
        gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
        gameLog.logEvent("Pass");
        gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
    }

    public void teamAttackPlay(){
        String attackPlay = gameEvent.attackEvent();
        if (Objects.equals(attackPlay, "On Target") ||
                "Off Target".equals(attackPlay) ||
                "Hit Woodwork".equals(attackPlay) ||
                "Offside".equals(attackPlay)){
            gameLog.logEvent(attackPlay);
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
        } else if (Objects.equals(attackPlay, "Shot")){
                gameLog.logEvent(attackPlay);
                String keeperEvent = gameEvent.keeperShotEvent();
                shotOutcome(keeperEvent);
        }
    }

    public void shotOutcome(String keeperEvent){
        if (Objects.equals(keeperEvent, "Goal")){
            gameLog.logEvent("GOAL!!");
            gameLog.logEvent(gameEvent.goalEventOpenPlay());
            engine.attackTeamSwitch();
            gameLog.logEvent("Kick Off");
            playStart();
        } else if (Objects.equals(keeperEvent, "Save")) {
            gameLog.logEvent(keeperEvent);
//            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
            engine.attackTeamSwitch();
        } else {
            gameLog.logEvent(keeperEvent);
            if (Objects.equals(gameEvent.outOfBoundsEvent(), "Out")){
                gameLog.logEvent("Out");
                gameLog.logEvent("Corner");
            } else {
                gameLog.logEvent("Back in Play");
            }
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
        }
    }


    public void teamEventPlay(){
        String teamPlay = gameEvent.teamEvent();
        if (Objects.equals(teamPlay, "Pass") ||
                "Long Pass".equals(teamPlay) ||
                "Backwards Pass".equals(teamPlay) ||
                "Dribble".equals(teamPlay)){
            gameLog.logEvent(teamPlay);
            while (gameLog.checkPlayerDribble()){
                gameLog.logEvent(gameEvent.teamEvent());
            }
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));

        } else {
            String defenderEvent = gameEvent.defendInPlayEvent();
            if (Objects.equals(defenderEvent, "Foul")){
                gameLog.logEvent(foulEventPicker());
                engine.attackTeamSwitch();
                gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
                //do something here
                if (gameLog.checkYellowCard()){
                    gameLog.addYellowCard();
                }
                if (gameLog.checkRedCard()){
                    gameLog.addRedCard();
                }
                engine.attackTeamSwitch();
                playStart();
            } else {
                gameLog.logEvent(defenderEvent);
                engine.attackTeamSwitch();
                gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
            }
        }
    }

    public void checkYellowCardedPlayers(String playerName){
        for (Card card:gameLog.getCardLog()){
            gameLog.logEvent(card.toString());
            System.out.println(card.toString());
            if (Objects.equals(card.getPlayerName(), playerName) && Objects.equals(card.getCardType(), "Yellow")){
                System.out.println("Player has already been booked!");
            }

        }
    }

    public void attackingPlayerEventPicker(){
        int r = RandomGenerator.randomPlay();
        switch (r) {
            case 0:
                teamEventPlay();
                break;
            case 1:
                teamAttackPlay();
                break;
            default : break;
        }
    }

    public void midfieldPlayerEventPicker(){
        int r = RandomGenerator.randomNumber();
        if (r < 75){
            teamEventPlay();
        } else {
            teamAttackPlay();
        }
    }

    public String foulEventPicker(){
        int r = RandomGenerator.randomNumber();
        if (r < 50){
            return "Foul";
        } else if (r > 50 && r < 90) {
            return "Yellow";
        } else {
            return "Red";
        }
    }

}
