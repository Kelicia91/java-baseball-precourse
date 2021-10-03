package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class DistinctDigitsGeneratorTest {

	@Test
	void generate() {
		final int length = 3;
		List<Integer> digits = DistinctDigitsGenerator.generate(length);
		DistinctDigitsValidator.validateDistinct(digits);
		assertThat(digits.size()).isEqualTo(length);
	}
}
