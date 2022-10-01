package baseball.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {

    @DisplayName("사용자 입력값은 3자리 숫자, 1~9까지의 숫자만 유효하다")
    @Test
    void validateInputNoExceptionTest() {
        // TODO: 2022/09/30 꼭 null을 넣어줘야할까.. start 나 static method 로 생성하는 방법?? 
        GameService service = new GameService(null);

        assertDoesNotThrow(() -> service.validateGameInput("123"));
        assertDoesNotThrow(() -> service.validateGameInput("456"));
        assertDoesNotThrow(() -> service.validateGameInput("789"));
    }

    @DisplayName("사용자 입력값이 올바르지 않을 경우 IllegalArgumentException 던진다")
    @Test
    void validateInputTest() {
        GameService service = new GameService(null);

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
        assertThatThrownBy(() -> service.validateGameInput("111"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input number has to be different");
        assertThatThrownBy(() -> service.validateGameInput("112"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input number has to be different");
    }

    @DisplayName("입력값과 정답을 비교하여 힌트를 출력한다")
    @Test
    void confirmInput() {
        GameService gameService = new GameService(new int[] {1, 2, 3});

        assertThat(gameService.getHint("124")).isEqualTo("2스트라이크");
        assertThat(gameService.getHint("321")).isEqualTo("2볼 1스트라이크");
        assertThat(gameService.getHint("361")).isEqualTo("2볼");
        assertThat(gameService.getHint("456")).isEqualTo("낫싱");
    }

}