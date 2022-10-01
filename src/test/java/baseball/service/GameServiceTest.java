package baseball.service;

import static baseball.constant.GameStatus.*;
import static baseball.constant.Message.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.dto.HintStatusDto;

class GameServiceTest {

    @DisplayName("사용자 입력값은 중복되지 않은 3자리 숫자, 1~9까지의 숫자만 유효하다")
    @Test
    void validateInputNoExceptionTest() {
        GameService service = GameService.getInstance();

        assertDoesNotThrow(() -> service.validateGameInput("123"));
        assertDoesNotThrow(() -> service.validateGameInput("456"));
        assertDoesNotThrow(() -> service.validateGameInput("789"));
    }

    @DisplayName("사용자 입력값이 올바르지 않을 경우 IllegalArgumentException 던진다")
    @Test
    void validateInputTest() {
        GameService service = GameService.getInstance();

        assertThatThrownBy(() -> service.validateGameInput(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_IS_NULL_MESSAGE);
        assertThatThrownBy(() -> service.validateGameInput("102"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_NOT_VALID_NUMBER_MESSAGE);
        assertThatThrownBy(() -> service.validateGameInput("a12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_NOT_VALID_NUMBER_MESSAGE);
        assertThatThrownBy(() -> service.validateGameInput("12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_LENGTH_ERROR_MESSAGE);
        assertThatThrownBy(() -> service.validateGameInput("1234"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_LENGTH_ERROR_MESSAGE);
        assertThatThrownBy(() -> service.validateGameInput("111"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_NUMBER_DUPLICATE_MESSAGE);
        assertThatThrownBy(() -> service.validateGameInput("112"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_NUMBER_DUPLICATE_MESSAGE);
    }

    @DisplayName("입력값과 정답을 비교하여 힌트를 출력한다")
    @Test
    void confirmInput() {
        GameService service = GameService.getInstance();

        HintStatusDto testCase1 = service.getHintAndStatus(new int[] {1, 2, 4}, new int[] {1, 2, 3});
        assertThat(testCase1.getHintMessage()).isEqualTo("2스트라이크");
        assertThat(testCase1.getStatus()).isEqualTo(CONTINUE);

        HintStatusDto testCase2 = service.getHintAndStatus(new int[] {3, 2, 1}, new int[] {1, 2, 3});
        assertThat(testCase2.getHintMessage()).isEqualTo("2볼 1스트라이크");
        assertThat(testCase2.getStatus()).isEqualTo(CONTINUE);

        HintStatusDto testCase3 = service.getHintAndStatus(new int[] {3, 6, 1}, new int[] {1, 2, 3});
        assertThat(testCase3.getHintMessage()).isEqualTo("2볼");
        assertThat(testCase3.getStatus()).isEqualTo(CONTINUE);

        HintStatusDto testCase4 = service.getHintAndStatus(new int[] {4, 5, 6}, new int[] {1, 2, 3});
        assertThat(testCase4.getHintMessage()).isEqualTo("낫싱");
        assertThat(testCase4.getStatus()).isEqualTo(CONTINUE);
    }

}