package Losson1.Action;

import Losson1.Patricipant.Patricipant;

public class Treadmill implements Action {

    private final int distance;


    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean passObstacleBy(Patricipant patricipant) {
        if(patricipant.runDistance() >= this.distance){
            System.out.printf("Участник %s успешно пробежал дистанцию %d%n",
                    patricipant, this.distance);
            return true;
        }else {
            System.out.printf("Участник %s не смог пробежать дистанцию %d%n",
                    patricipant, this.distance);
            return false;
        }
    }
}
