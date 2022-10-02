package baseball.dto;

import static baseball.constant.GameStatus.*;
import static baseball.constant.Message.*;

import baseball.constant.GameStatus;

public class HintStatusDto {
    private String hintMessage;
    private GameStatus status;

    public String getHintMessage() {
        return hintMessage;
    }

    public GameStatus getStatus() {
        return status;
    }

    public HintStatusDto(String hintMessage, GameStatus status) {
        this.hintMessage = hintMessage;
        this.status = status;
    }

    public static HintStatusDto nothing() {
        return new HintStatusDto(NOTHING_MESSAGE, CONTINUE);
    }
}
