package baseball.service;

import static baseball.constant.GoStop.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProgressServiceTest {

    @DisplayName("start 메소드는 게임이 끝나면 재개여부input 을 받아 GoStop을 리턴한다")
    @Test
    void test() {
        ProgressService service = new ProgressService(new int[] {1, 2, 3});
        command("123", "1");
        assertThat(service.start()).isEqualTo(GO);
        command("123", "2");
        assertThat(service.start()).isEqualTo(STOP);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}