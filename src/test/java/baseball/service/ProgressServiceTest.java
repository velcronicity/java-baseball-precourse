package baseball.service;

import static baseball.constant.GameStatus.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProgressServiceTest {

    @DisplayName("힌트에 따라 계속 사용자 입력받을지 게임종료 입력받을 지 결정")
    @Test
    void start() {
        ProgressService progressService = new ProgressService(new int[] {1, 2, 3});
        assertThat(progressService.getGameStatus(new int[] {1, 2, 3})).isEqualTo(DONE);
        assertThat(progressService.getGameStatus(new int[] {1, 2, 4})).isEqualTo(CONTINUE);
    }

}