package baseball.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @DisplayName("사용자 입력값은 3자리 숫자, 1~9까지의 숫자만 유효하다")
    @Test
    void validateInputNoExceptionTest() {
        GameService service = new GameService();

        assertDoesNotThrow(() -> service.validateGameInput("123"));
        assertDoesNotThrow(() -> service.validateGameInput("456"));
        assertDoesNotThrow(() -> service.validateGameInput("789"));
    }

    @DisplayName("사용자 입력값이 올바르지 않을 경우 IllegalArgumentException 던진다")
    @Test
    void validateInputTest() {
        GameService service = new GameService();

        assertThatThrownBy(() -> service.validateGameInput(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input is null");
        assertThatThrownBy(() -> service.validateGameInput("102"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input should be number 1 to 9");
        assertThatThrownBy(() -> service.validateGameInput("a12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input should be number 1 to 9");
        assertThatThrownBy(() -> service.validateGameInput("12"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input length is not 3");
        assertThatThrownBy(() -> service.validateGameInput("1234"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input length is not 3");
    }

}