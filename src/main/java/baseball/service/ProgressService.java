package baseball.service;

import static baseball.constant.GameStatus.*;
import static baseball.constant.GoStop.*;
import static baseball.constant.Message.*;
import static camp.nextstep.edu.missionutils.Console.*;

import baseball.constant.GoStop;
import baseball.dto.HintStatusDto;

public class ProgressService {

    private final int[] answer;
    private final GameService gameService;

    public ProgressService(int[] answer) {
        this.answer = answer;
        this.gameService = GameService.getInstance();
    }

    public GoStop start() {
        while (true) {
            String gameInput = readGameInput();
            gameService.validateGameInput(gameInput);
            HintStatusDto hintStatusDto = gameService.getHintAndStatus(toIntArray(gameInput), answer);
            System.out.println(hintStatusDto.getHintMessage());
            if (hintStatusDto.getStatus() == DONE) {
                System.out.println(CORRECT_MESSAGE);
                break;
            }
        }
        String goStopInput = readGoStopInput();
        return findGoStop(goStopInput);
    }

    private String readGameInput() {
        System.out.print(GAME_INPUT_MESSAGE);
        return readLine();
    }

    private String readGoStopInput() {
        System.out.println(GO_STOP_INPUT_MESSAGE);
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
