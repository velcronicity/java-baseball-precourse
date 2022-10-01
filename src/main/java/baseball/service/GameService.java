package baseball.service;

import static baseball.constant.GameStatus.*;
import static baseball.constant.Message.*;

import baseball.constant.GameStatus;
import baseball.dto.HintStatusDto;

public class GameService {

    private static final GameService instance = new GameService();

    public static GameService getInstance() {
        return instance;
    }

    private GameService() {
    }

    public void validateGameInput(String gameInput) {
        if (gameInput == null)
            throw new IllegalArgumentException(INPUT_IS_NULL_MESSAGE);
        if (gameInput.length() != 3)
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        char[] inputArray = gameInput.toCharArray();
        checkEachNumber(inputArray);
        if (isDuplicate(inputArray))
            throw new IllegalArgumentException(INPUT_NUMBER_DUPLICATE_MESSAGE);
    }

    public HintStatusDto getHintAndStatus(int[] gameInput, int[] answer) {
        int strikeCount = getStrikeCount(gameInput, answer);
        int ballCount = getBallCount(gameInput, answer);
        if (strikeCount == 0 && ballCount == 0)
            return new HintStatusDto(NOTHING_MESSAGE, CONTINUE);
        GameStatus status = strikeCount == 3 ? DONE : CONTINUE;
        return new HintStatusDto(makeHintMessage(ballCount, strikeCount), status);
    }

    private void checkEachNumber(char[] number) {
        for (char eachNumber : number) {
            checkValidNumber(eachNumber);
        }
    }

    private void checkValidNumber(char eachNumber) {
        if (eachNumber < '1' || eachNumber > '9')
            throw new IllegalArgumentException(INPUT_NOT_VALID_NUMBER_MESSAGE);
    }

    private boolean isDuplicate(char[] inputArray) {
        return inputArray[0] == inputArray[1] || inputArray[0] == inputArray[2] || inputArray[1] == inputArray[2];
    }

    private int getStrikeCount(int[] gameInput, int[] answer) {
        int strikeCount = 0;
        if (answer[0] == gameInput[0])
            strikeCount++;
        if (answer[1] == gameInput[1])
            strikeCount++;
        if (answer[2] == gameInput[2])
            strikeCount++;
        return strikeCount;
    }

    private int getBallCount(int[] gameInput, int[] answer) {
        int ballCount = 0;
        if (gameInput[0] == answer[1] || gameInput[0] == answer[2])
            ballCount++;
        if (gameInput[1] == answer[0] || gameInput[1] == answer[2])
            ballCount++;
        if (gameInput[2] == answer[0] || gameInput[2] == answer[1])
            ballCount++;
        return ballCount;
    }

    private String makeHintMessage(int ballCount, int strikeCount) {
        return String.format("%s %s",
            makeBallStringHintMessage(ballCount, "볼"),
            makeBallStringHintMessage(strikeCount, "스트라이크"))
            .trim();
    }

    private String makeBallStringHintMessage(int count, String ballOrStrike) {
        if (count == 0)
            return "";
        return String.format("%d%s", count, ballOrStrike);
    }

}
