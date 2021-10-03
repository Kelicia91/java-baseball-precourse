package baseball;

import java.util.Arrays;

import nextstep.utils.Console;

class NBView {

	enum NBText {
		INPUT_DIGITS("숫자를 입력해주세요 : "),
		NOTHING("낫싱"),
		BALL("%d볼"),
		STRIKE("%d스트라이크"),
		GAME_OVER("%d개의 숫자를 모두 맞히셨습니다! 게임 끝"),
		INPUT_COMMAND("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요."),
		ERROR("[ERROR] %s");

		NBText(String value) { this.value = value; }

		private final String value;
		public String getValue() { return value; }
	}

	public void outError(String msg) {
		println(String.format(NBText.ERROR.getValue(), msg));
	}

	public void outGameOver(int digitsLength) {
		println(String.format(NBText.GAME_OVER.getValue(), digitsLength));
	}

	public void outInputCommand(String restartCommand, String exitCommand) {
		println(String.format(NBText.INPUT_COMMAND.getValue(), restartCommand, exitCommand));
	}

	public void outInputDigits() {
		print(NBText.INPUT_DIGITS.getValue());
	}

	public void outResult(int digitsLength, NBDigitsMatchCounter.Result result) {
		if (result.getCountNothing() == digitsLength) {
			println(NBText.NOTHING.getValue());
			return;
		}
		println(String.join(" ", Arrays.asList(
			formatByCount(NBText.STRIKE.getValue(), result.getCountStrike()),
			formatByCount(NBText.BALL.getValue(), result.getCountBall())
		)).trim());
	}

	public String inSafeInput() {
		String input;
		do {
			input = input();
		} while(null == input);
		return input;
	}

	private String input() {
		String input = null;
		try {
			input = Console.readLine();
		} catch (IllegalStateException e) {
			// @note: NoSuchElementException 까지 잡았더니 ApplicationTest.낫싱() 테스트가 종료되지 않음
			outError(e.getMessage());
		}
		return input;
	}

	private String formatByCount(String format, int count) {
		if (count <= 0) {
			return "";
		}
		return String.format(format, count);
	}

	private void print(String s) { System.out.print(s); }
	private void println(String s) { System.out.println(s); }
}
