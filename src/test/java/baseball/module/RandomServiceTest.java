package baseball.module;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.service.RandomService;

class RandomServiceTest {

    @DisplayName("정답 생성. 숫자 3개는 모두 달라야한다. 1부터 9사이여야한다.")
    @Test
    void pickNumberTest() {
        //given
        HashSet<Integer> set = new HashSet<>();
        RandomService randomService = new RandomService();

        //when
        int[] numberArray = randomService.pickNumber();

        //then
        assertThat(numberArray).hasSize(3);
        checkEachNumber(set, numberArray);
        assertThat(set.size()).isEqualTo(3);
    }

    private void checkEachNumber(HashSet<Integer> set, int[] numberArray) {
        for (int number : numberArray) {
            assertThat(number).isNotZero();
            assertThat(number).isBetween(1, 9);
            set.add(number);
        }
    }

}