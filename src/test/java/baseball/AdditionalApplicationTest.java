package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class AdditionalApplicationTest extends NsTest {
    @Test
    void 게임_한판만하고_종료() {
        assertRandomNumberInRangeTest(
            () -> {
                run("135", "2");
                assertThat(output()).contains("3스트라이크", "게임 종료");
            },
            1, 3, 5
        );
    }

    @Test
    void 볼_스트라이크_다양한_메세지_확인() {
        assertRandomNumberInRangeTest(
            () -> {
                run("231", "124", "172", "456", "123", "2");
                assertThat(output()).contains("3볼", "2스트라이크", "1볼 1스트라이크", "낫싱", "3스트라이크", "게임 종료");
            },
            1, 2, 3
        );
    }

    @Test
    void 숫자_0_입력했을때_예외() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("012"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효하지않은_문자가_입력됐을때() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("abc"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("한국어"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
