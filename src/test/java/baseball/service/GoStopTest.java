package baseball.service;

import static baseball.constant.GoStop.*;
import static baseball.constant.Message.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GoStopTest {

    @DisplayName("goStopInput 에 따라 GoStop enum 을 리턴")
    @Test
    void determineGoStopTest() {
        assertThat(findGoStop("1")).isEqualTo(GO);
        assertThat(findGoStop("2")).isEqualTo(STOP);
        assertThatThrownBy(() -> findGoStop("3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(GO_STOP_INPUT_NOT_VALID_MESSAGE);
        assertThatThrownBy(() -> findGoStop(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(GO_STOP_INPUT_NOT_VALID_MESSAGE);
    }

}