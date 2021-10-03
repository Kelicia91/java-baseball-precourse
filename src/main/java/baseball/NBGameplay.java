package baseball;

class NBGameplay {

	private final NBDigitsMatchCounter matchCounter;
	private final NBView view;

	public NBGameplay() {
		this.matchCounter = new NBDigitsMatchCounter();
		this.view = new NBView();
	}

	public void run(int digitsLength) {
		NBDigits hidden = NBDigits.build(digitsLength);
		boolean isAllStrike;
		do {
			NBDigitsMatchCounter.Result result = turn(hidden);
			view.outResult(digitsLength, result);
			isAllStrike = (result.getCountStrike() == digitsLength);
		} while (!isAllStrike);
	}

	private NBDigitsMatchCounter.Result turn(NBDigits hidden) {
		NBDigits tried;
		do {
			tried = tryStrike(hidden);
		} while (null == tried);
		return matchCounter.count(hidden, tried);
	}

	private NBDigits tryStrike(NBDigits hidden) {
		NBDigits tried;
		try {
			view.outInputDigits();
			tried = NBDigits.build(view.inSafeInput());
			validateDigitsLength(hidden.length(), tried.length());
		} catch (IllegalArgumentException e) {
			view.outError(e.getMessage());
			tried = null;
		}
		return tried;
	}

	private void validateDigitsLength(int expected, int actual) {
		if (expected != actual) {
			throw new IllegalArgumentException(String.format("length of digits must be %d", expected));
		}
	}
}
