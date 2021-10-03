package baseball;

public class Application {
    public static void main(String[] args) {
        final int DIGITS_LENGTH = 3;
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.run(DIGITS_LENGTH);
    }
}
