package baseball.module;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExternalModuleTest {

    @DisplayName("랜덤값 추출 함수 테스트")
    @Test
    void pickNumberInRangeTest() {
        for (int i = 0; i < 100; i++) {
            assertThat(pickNumberInRange(1, 9)).isNotZero();
        }
        for (int i = 0; i < 100; i++) {
            assertThat(pickNumberInRange(0, 0)).isZero();
        }
    }
}
