package baseball;

import java.util.List;

import org.junit.jupiter.api.Test;

class DistinctDigitsGeneratorTest {

	@Test
	void generate() {
		List<Integer> digits = DistinctDigitsGenerator.generate(3);
		DistinctDigitsValidator.validateDistinct(digits);
	}
}
