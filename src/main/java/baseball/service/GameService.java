package baseball.service;

public class GameService {

    public void validateGameInput(String gameInput) {
        if (gameInput == null)
            throw new IllegalArgumentException("input is null");
        if (gameInput.length() != 3)
            throw new IllegalArgumentException("input length is not 3");
        char[] inputArray = gameInput.toCharArray();
        for (char eachNumber : inputArray) {
            checkNumber(eachNumber);
        }
    }

    private void checkNumber(char number) {
        if (number < '1' || number > '9')
            throw new IllegalArgumentException("input should be number 1 to 9");
    }
}
