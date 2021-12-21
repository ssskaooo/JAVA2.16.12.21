package Losson1;

import Losson1.Action.Action;
import Losson1.Action.Treadmill;
import Losson1.Action.Wall;
import Losson1.Patricipant.Cat;
import Losson1.Patricipant.Human;
import Losson1.Patricipant.Patricipant;
import Losson1.Patricipant.Robot;

import java.util.List;
import java.util.Random;

public class TestHW {

    public static void main(String[] args) {
        System.out.println("Подготовительный этап");
        Competition competition = createAndPrepareCompetition();

        System.out.println("Начинаем соревнования");
        competition.startCompetition();

        List<Patricipant> lastWinners = competition.getLastWinners();
        if(!lastWinners.isEmpty()){
            System.out.println("Победители: ");
            for (Patricipant lastWinner : lastWinners){
                System.out.println(lastWinner);
            }
        }else {
            System.out.println("Никто не смог преодолеть дистанцию");
        }
    }

    private static Competition createAndPrepareCompetition() {
        Patricipant person = new Human("Oleg", 2, 300);
        Patricipant cat = new Cat("Tomas", 5, 50);
        Patricipant robot = new Robot("Bob", 15, 500);

        Random random = new Random();

        Action wall = new Wall(random.nextInt(20));
        Action track = new Treadmill(random.nextInt(350));

        Competition competition = new Competition("Марафон");
        competition.setActions(wall,track);
        competition.setPatricipants(person,cat,robot);
        return competition;
    }
}
