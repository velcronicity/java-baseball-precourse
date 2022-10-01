package baseball.service;

import static baseball.service.GameStatus.*;
import static baseball.service.GoStop.*;
import static baseball.service.Message.*;
import static camp.nextstep.edu.missionutils.Console.*;

public class ProgressService {

    private final GameService gameService;

    public ProgressService(GameService gameService) {
        this.gameService = gameService;
    }

    public GoStop start() {
        GameStatus status = CONTINUE;
        while (status == CONTINUE) {
            String gameInput = readGameInput();
            gameService.validateGameInput(gameInput);
            status = getGameStatus(gameInput);
        }
        String goStopInput = readGoStopInput();
        return findGoStop(goStopInput);
    }

    public GameStatus getGameStatus(String input) {
        String hint = gameService.getHint(input);
        System.out.println(hint);
        if (ALL_STRIKE_MESSAGE.equals(hint)) {
            System.out.println(CORRECT_MESSAGE);
            return DONE;
        }
        return CONTINUE;
    }

    private String readGoStopInput() {
        System.out.println(GO_STOP_INPUT_MESSAGE);
        return readLine();
    }

    private String readGameInput() {
        System.out.print(GAME_INPUT_MESSAGE);
        return readLine();
    }
}
