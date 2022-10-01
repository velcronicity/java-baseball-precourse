package baseball.service;

import static baseball.constant.GameStatus.*;
import static baseball.constant.GoStop.*;
import static baseball.constant.Message.*;
import static camp.nextstep.edu.missionutils.Console.*;

import baseball.constant.GameStatus;
import baseball.constant.GoStop;

public class ProgressService {

    private final int[] answer;
    private final GameService gameService;

    public ProgressService(int[] answer) {
        this.answer = answer;
        this.gameService = new GameService();
    }

    public GoStop start() {
        GameStatus status = CONTINUE;
        while (status == CONTINUE) {
            String gameInput = readGameInput();
            gameService.validateGameInput(gameInput);
            status = getGameStatus(toIntArray(gameInput));
        }
        String goStopInput = readGoStopInput();
        return findGoStop(goStopInput);
    }

    public GameStatus getGameStatus(int[] input) {
        String hint = gameService.getHint(input, answer);
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

    private int[] toIntArray(String gameInput) {
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = gameInput.charAt(i) - '0';
        }
        return array;
    }
}
