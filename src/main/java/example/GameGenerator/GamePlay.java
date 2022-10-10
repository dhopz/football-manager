package example.GameGenerator;

import example.Player;
import example.RandomGenerator;
import example.Team;
import org.jetbrains.annotations.NotNull;

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

    public GamePlay(@NotNull Team homeTeam, Team awayTeam) {
        this.gameEvent = new GameEvent();
        this.gameLog = new GameLog();
        this.homeTeam = homeTeam.getLongName();
        this.awayTeam = awayTeam.getLongName();
        this.engine = new Engine(homeTeam, awayTeam);

    }

    public void constructPlay(){
        gameStart();
        for (int i = 1; i < 10; i++) {
            teamEventPlay();
            if (engine.checkForwardPlayer(gameLog.getPlayerLog())){
                teamAttackPlay();
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
            gameLog.logEvent(gameEvent.goalEvent());
            engine.attackTeamSwitch();
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
        } else {
            gameLog.logEvent(gameEvent.defendInPlayEvent());
            engine.attackTeamSwitch();
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
            while (gameLog.dribbleEvent()){
                gameLog.logEvent(gameEvent.teamEvent());
            }
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));

        } else {
            gameLog.logEvent(gameEvent.defendInPlayEvent());
            engine.attackTeamSwitch();
            gameLog.logPlayEvent(engine.checkPlayer(gameLog.getPlayerLog()));
        }
    }

}
