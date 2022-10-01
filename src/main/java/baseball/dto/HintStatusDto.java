package baseball.dto;

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
}
