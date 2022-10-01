package baseball.constant;

import static baseball.constant.Message.*;

public enum GoStop {
    GO("1"), STOP("2");

    private String code;

    GoStop(String code) {
        this.code = code;
    }

    public static GoStop findGoStop(String input) {
        if (GO.code.equals(input))
            return GO;
        if (STOP.code.equals(input))
            return STOP;
        throw new IllegalArgumentException(GO_STOP_INPUT_NOT_VALID_MESSAGE);
    }
}
