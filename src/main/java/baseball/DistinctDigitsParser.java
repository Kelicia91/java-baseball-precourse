package baseball;

import java.util.ArrayList;
import java.util.List;

class DistinctDigitsParser {

	public static List<Integer> parseInput(String input) {
		String s = input.trim();
		DistinctDigitsValidator.validateLength(s.length());
		DistinctDigitsValidator.validateDigit(s);

		List<Integer> digits = parse(s);
		DistinctDigitsValidator.validateDistinct(digits);
		return digits;
	}

	private static List<Integer> parse(String s) {
		final int length = s.length();
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < length; ++i) {
			digits.add(Integer.parseInt(String.valueOf(s.charAt(i))));
		}
		return digits;
	}
}
