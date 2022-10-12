package example.GameGenerator;

import example.RandomGenerator;

public class GameEvent {
    public String teamEvent() {
        String[] teamPlay = new String[]{
                "Pass",
                "Through Ball",
                "Long Pass",
                "Dribble",
                "Backwards Pass",
//                "Cross",
//                "Corner"
        };
        return RandomGenerator.getRandomEvent(teamPlay);
    }
    public String defenceEvent() {
        String[] defencePlay = new String[]{
                "Block",
                "Interception",
                "Tackle",
                "Last Man Tackle",
                "Clearance",
                "Headed Clearance",
                "Opponent Offside",
                "Own Goal",
                "Penalty Conceded",
                "Foul"
        };
        return RandomGenerator.getRandomEvent(defencePlay);
    }
    public String defendInPlayEvent(){
        String[] defencePlay = new String[]{
                "Interception",
                "Tackle",
//                "Foul"
        };
        return RandomGenerator.getRandomEvent(defencePlay);
    }
    public String keeperEvent(){
        String[] keeperPlay = new String[]{
                "Save",
                "Tackle",
                "Clearance",
                "Penalty Conceded"
        };
        return RandomGenerator.getRandomEvent(keeperPlay);
    }

    public String keeperShotEvent(){
        String[] keeperPlay = new String[]{
                "Save",
                "Deflected",
                "Goal"
        };
        return RandomGenerator.getRandomEvent(keeperPlay);
    }


    public String goalEventOpenPlay(){
        String[] goalPlay = new String[]{
                "Goal from Header",
                "Goal from Inside Box",
                "Goal from Outside Box"
        };
        return RandomGenerator.getRandomEvent(goalPlay);
    }

    public String goalEventClosedPlay(){
        String[] goalPlay = new String[]{
                "Goal from Penalty",
                "Goal from Free kick"
        };
        return RandomGenerator.getRandomEvent(goalPlay);
    }


    public String attackEvent(){
        String[] attackPlay = new String[]{
                "Shot",
                "On Target",
                "Off Target",
                "Hit Woodwork",
                "Offside"
        };
        return RandomGenerator.getRandomEvent(attackPlay);

    }


}
