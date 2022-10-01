package baseball.service;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.HashSet;

public class RandomService {

    public int[] pickNumber() {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            set.add(pickNumberInRange(1, 9));
        }
        return setToArray(set);
    }

    private int[] setToArray(HashSet<Integer> set) {
        int[] number = new int[3];
        int index = 0;
        for (Integer eachNumber : set) {
            number[index++] = eachNumber;
        }
        return number;
    }
}
