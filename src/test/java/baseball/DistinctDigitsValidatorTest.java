package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DistinctDigitsValidatorTest {

	@Test
	void validateLength_too_short() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> DistinctDigitsValidator.validateLength(0))
			.withMessageContaining("too short");
	}

	@Test
	void validateLength_too_long() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> DistinctDigitsValidator.validateLength(10))
			.withMessageContaining("too long");
	}

	@Test
	void validateDistinct_duplication() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				List<Integer> digits = Arrays.asList(1, 2, 2);
				DistinctDigitsValidator.validateDistinct(digits);
			})
			.withMessageContaining("distinct");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " ", " 1", "1a A-", "01"})
	void validateDigit_invalid(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> DistinctDigitsValidator.validateDigit(input))
			.withMessageContaining("[1,9]");
	}
}
