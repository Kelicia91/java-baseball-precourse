package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class NBDigitsMatchCounter {

	public Result count(NBDigits hidden, NBDigits tried) {
		List<NBDigits.Matching> matches = matchAll(hidden, tried);
		int countStrike = count(matches, NBDigits.Matching.STRIKE::equals);
		int countBall = count(matches, NBDigits.Matching.BALL::equals);
		int countNothing = count(matches, NBDigits.Matching.NOTHING::equals);
		return Result.build(countStrike, countBall, countNothing);
	}

	private List<NBDigits.Matching> matchAll(NBDigits hidden, NBDigits tried) {
		final int length = tried.length();
		List<NBDigits.Matching> matches = new ArrayList<>();
		for (int i = 0; i < length; ++i) {
			Integer digit = tried.get(i);
			matches.add(hidden.match(i, digit));
		}
		return matches;
	}

	private int count(List<NBDigits.Matching> matches, Function<NBDigits.Matching, Boolean> equals) {
		int count = 0;
		for (NBDigits.Matching m : matches) {
			count += (equals.apply(m) ? 1 : 0);
		}
		return count;
	}

	static class Result {
		private final int countStrike;
		private final int countBall;
		private final int countNothing;

		private Result(int countStrike, int countBall, int countNothing) {
			this.countStrike = countStrike;
			this.countBall = countBall;
			this.countNothing = countNothing;
		}

		public static Result build(int countStrike, int countBall, int countNothing) {
			return new Result(countStrike, countBall, countNothing);
		}

		public int getCountStrike() { return countStrike; }
		public int getCountBall() { return countBall; }
		public int getCountNothing() { return countNothing; }
	}
}
