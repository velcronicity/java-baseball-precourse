package baseball.service;

import static baseball.service.GameStatus.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProgressServiceTest {

    @DisplayName("힌트에 따라 계속 사용자 입력받을지 게임종료 입력받을 지 결정")
    @Test
    void start() {
        GameService gameService = GameService.newGame(new int[] {1, 2, 3});
        ProgressService progressService = new ProgressService(gameService);
        assertThat(progressService.getGameStatus("123")).isEqualTo(DONE);
        assertThat(progressService.getGameStatus("124")).isEqualTo(CONTINUE);
    }

}