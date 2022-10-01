package baseball;

import static baseball.service.GameService.*;
import static baseball.service.GoStop.*;

import baseball.service.GameService;
import baseball.service.GoStop;
import baseball.service.ProgressService;
import baseball.service.RandomService;

public class Application {
    public static void main(String[] args) {
        RandomService randomService = new RandomService();
        GoStop goStop = GO;
        while (goStop == GO) {
            ProgressService progressService = new ProgressService(makeNewGame(randomService));
            goStop = progressService.start();
        }
    }

    private static GameService makeNewGame(RandomService randomService) {
        return newGame(randomService.pickNumber());
    }
}
