package baseball;

import java.util.HashSet;
import java.util.List;

class DistinctDigitsValidator {

	private static final String REGEX_DIGITS = "[1-9]+";

	public static void validateLength(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("too small length; must be [1,9].");
		}
		if (length > 9) {
			throw new IllegalArgumentException("too big length; must be [1,9].");
		}
	}

	public static void validateDistinct(List<Integer> digits) {
		if (digits.size() != (new HashSet<>(digits)).size()) {
			throw new IllegalArgumentException("it must contain distinct digits.");
		}
	}

	public static void validateDigit(String input) {
		if (!input.matches(REGEX_DIGITS)) {
			throw new IllegalArgumentException("it must contain digits.");
		}
	}
}
