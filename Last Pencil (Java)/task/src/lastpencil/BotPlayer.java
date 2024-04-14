package lastpencil;

import java.util.concurrent.ThreadLocalRandom;

public class BotPlayer extends Player{

    public BotPlayer(String name) {
        super(name);
    }

    @Override
    public int takePencils(int currentPencils) {
        int pencilsTaken;
        if (currentPencils == 1) {
            pencilsTaken = 1;
        } else {
            int strategy;
            for (strategy = 0; strategy <= 3; strategy++) {
                if ((currentPencils + strategy - 1) % 4 == 0) {
                    break;
                }
            }
            if (strategy == 0) {
                pencilsTaken = ThreadLocalRandom.current().nextInt(1,4);
            } else {
                pencilsTaken = 3 - (strategy - 1);
            }
        }
        System.out.println(pencilsTaken);
        return currentPencils - pencilsTaken;
    }
}
