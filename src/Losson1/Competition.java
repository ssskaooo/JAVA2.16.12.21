package Losson1;

import Losson1.Action.Action;
import Losson1.Patricipant.Patricipant;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private Action[] actions;
    private Patricipant[] patricipants;
    private final String competitionTitle;

    private final List<Patricipant> lastWinners = new ArrayList<>();

    public Competition(String competitionTitle) {
        this.competitionTitle = competitionTitle;
    }

    public void setPatricipants(Patricipant ...patricipants) {
        this.patricipants = patricipants;
    }

    public void setActions(Action ...actions) {
        this.actions = actions;
    }

    public List<Patricipant> getLastWinners() {
        return lastWinners;
    }

    public void startCompetition(){
        System.out.printf("Начало соревнования %s%n" ,this.competitionTitle);
        this.lastWinners.clear();

        for(Patricipant patricipant : this.patricipants){
            boolean success = this.passAllAction((patricipant));
            if(!success){
                System.out.printf("Участник %s покинул соревнования %%n", patricipants);
            } else {
                this.lastWinners.add(patricipant);
            }
        }
    }

    private boolean passAllAction(Patricipant patricipant){
        for (Action action : this.actions) {
            if(!action.passObstacleBy(patricipant)){
                return false;
            }
        }
        return true;
    }
}
