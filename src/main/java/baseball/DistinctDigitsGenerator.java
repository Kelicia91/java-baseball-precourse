package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

class DistinctDigitsGenerator {

	public static List<Integer> generate(int length) {
		DistinctDigitsValidator.validateLength(length);

		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < length; ++i) {
			digits.add(pickDigit(digits));
		}
		return digits;
	}

	private static int pickDigit(List<Integer> digitsToExclude) {
		int digit;
		do {
			digit = Randoms.pickNumberInRange(1, 9);
		} while(digitsToExclude.contains(digit));
		return digit;
	}
}
