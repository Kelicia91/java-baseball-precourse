package baseball;

import java.util.List;

class NBDigits {

	enum Matching {
		NOTHING,
		BALL,
		STRIKE
	}

	private final List<Integer> digits;

	private NBDigits(int length) {
		this.digits = DistinctDigitsGenerator.generate(length);
	}

	private NBDigits(String input) {
		this.digits = DistinctDigitsParser.parseInput(input);
	}

	public static NBDigits build(int length) { return new NBDigits(length); }
	public static NBDigits build(String input) { return new NBDigits(input); }

	public int length() { return this.digits.size(); }

	public Integer get(int index) { return this.digits.get(index); }

	public Matching match(int index, int digit) {
		if (hasStrike(index, digit)) { return Matching.STRIKE; }
		else if (hasBall(index, digit)) { return Matching.BALL; }
		return Matching.NOTHING;
	}

	private boolean hasStrike(int index, Integer digit) {
		return get(index).equals(digit);
	}

	private boolean hasBall(int index, Integer digit) {
		return !hasStrike(index, digit) && this.digits.contains(digit);
	}
}
