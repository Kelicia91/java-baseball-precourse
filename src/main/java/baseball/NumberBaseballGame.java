package baseball;

public class NumberBaseballGame { // originate from BullsAndCowsGame

	private final NBGameplay play;
	private final NBView view;

	public NumberBaseballGame() {
		this.play = new NBGameplay();
		this.view = new NBView();
	}

	enum Command {
		NONE("0"),
		RESTART("1"),
		EXIT("2");

		Command(String value) { this.value = value; }

		private final String value;
		public String getValue() { return value; }
	}

	public void run(int digitsLength) {
		do {
			play.run(digitsLength);
			view.outGameOver(digitsLength);
		} while (Command.RESTART.equals(command()));
	}

	private Command command() {
		Command command;
		do {
			view.outInputCommand(Command.RESTART.getValue(), Command.EXIT.getValue());
			command = parse(view.inSafeInput());
		} while (Command.NONE.equals(command));
		return command;
	}

	private Command parse(String input) {
		if (input.equals(Command.RESTART.getValue())) {
			return Command.RESTART;
		} else if (input.equals(Command.EXIT.getValue())) {
			return Command.EXIT;
		}
		return Command.NONE;
	}
}
