package baseball;

import static baseball.constant.GoStop.*;

import baseball.constant.GoStop;
import baseball.service.ProgressService;
import baseball.service.RandomService;

public class Application {
    public static void main(String[] args) {
        RandomService randomService = new RandomService();
        GoStop goStop = GO;
        while (goStop == GO) {
            ProgressService progressService = new ProgressService(randomService.pickNumber());
            goStop = progressService.start();
        }
    }
}
