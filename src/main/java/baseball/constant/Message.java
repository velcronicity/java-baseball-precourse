package baseball.constant;

public class Message {

    private Message() {
        //do not construct this class
    }

    public static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String ALL_STRIKE_MESSAGE = "3스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String GO_STOP_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GO_STOP_INPUT_NOT_VALID_MESSAGE = "goStop input is not 1 or 2";

    public static final String INPUT_IS_NULL_MESSAGE = "input is null";
    public static final String INPUT_LENGTH_ERROR_MESSAGE = "input length is not 3";
    public static final String INPUT_NUMBER_DUPLICATE_MESSAGE = "input number has to be different";
    public static final String INPUT_NOT_VALID_NUMBER_MESSAGE = "input should be number 1 to 9";

}
