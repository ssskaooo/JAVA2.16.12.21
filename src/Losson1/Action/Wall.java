package Losson1.Action;

import Losson1.Patricipant.Patricipant;

public class Wall implements Action {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }


    @Override
    public boolean passObstacleBy(Patricipant patricipant) {
        if(patricipant.jumpHeight() >= this.height){
            System.out.printf("Участник %s успешно перепрыгнул через стену %d%n",
                    patricipant, this.height);
            return true;
        }else {
            System.out.printf("Участник %s не смог перепрыгнуть через стену %d%n",
                    patricipant, this.height);
            return false;
        }
    }
}
