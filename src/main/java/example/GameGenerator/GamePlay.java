package example.GameGenerator;

import example.Player;
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
        for (int i = 1; i < 20; i++) {
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
        Player player = engine.playerSelect(kickOffTeam);
        gameLog.logPlayEvent(player);
        gameLog.logEvent("Pass");
        Player player1 = engine.checkPlayer(gameLog.getPlayerLog());
        gameLog.logPlayEvent(player1);
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
    //            gameLog.logEvent(gameEvent.goalEventOpenPlay());

                String keeperEvent = gameEvent.keeperShotEvent();

                if (Objects.equals(keeperEvent, "Goal")){
                    gameLog.logEvent("GOAL!!");
                    gameLog.logEvent(gameEvent.goalEventOpenPlay());
//                    gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
                    engine.attackTeamSwitch();
                    gameStart();
                } else {
                    gameLog.logEvent(keeperEvent);
                    gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
                    engine.attackTeamSwitch();
                }

        } else {
            gameLog.logEvent(gameEvent.defendInPlayEvent());
            engine.attackTeamSwitch();
        }
//            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
//        engine.attackTeamSwitch();
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
            gameLog.logEvent(gameEvent.defendInPlayEvent());
            engine.attackTeamSwitch();
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
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

}