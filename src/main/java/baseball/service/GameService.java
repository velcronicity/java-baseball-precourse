package baseball.service;

public class GameService {

    private final int[] answer;

    public GameService(int[] answer) {
        this.answer = answer;
    }

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

    // TODO: 2022/10/01 리팩토링 
    public String getHint(String input) {
        int answer1 = answer[0];
        int answer2 = answer[1];
        int answer3 = answer[2];

        char[] inputArray = input.toCharArray();
        int input1 = inputArray[0] - '0';
        int input2 = inputArray[1] - '0';
        int input3 = inputArray[2] - '0';

        int strikeCount = 0, ballCount = 0;

        if (answer1 == input1)
            strikeCount++;
        if (answer2 == input2)
            strikeCount++;
        if (answer3 == input3)
            strikeCount++;

        if (input1 == answer2 || input1 == answer3)
            ballCount++;
        if (input2 == answer1 || input2 == answer3)
            ballCount++;
        if (input3 == answer1 || input3 == answer2)
            ballCount++;

        if (strikeCount == 0 && ballCount == 0)
            return "낫싱";

        return (ballHint(ballCount) + strikeHint(strikeCount)).trim();
    }

    private String ballHint(int ballCount) {
        if (ballCount == 0)
            return "";
        return ballCount + "볼 ";
    }

    private String strikeHint(int strikeCount) {
        if (strikeCount == 0)
            return "";
        return strikeCount + "스트라이크";
    }

    // TODO: 2022/09/30 private method 순서 확인
    private void checkNumber(char number) {
        if (number < '1' || number > '9')
            throw new IllegalArgumentException("input should be number 1 to 9");
    }
}
