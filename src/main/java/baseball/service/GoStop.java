package baseball.service;

public enum GoStop {
    GO("1"), STOP("2");

    private String code;

    GoStop(String code) {
        this.code = code;
    }

    public static GoStop findGoStop(String input) {
        if (GO.code.equals(input))
            return GO;
        if (STOP.code.equals(input))
            return STOP;
        throw new IllegalArgumentException("go stop input is not 1 or 2");
    }
}
