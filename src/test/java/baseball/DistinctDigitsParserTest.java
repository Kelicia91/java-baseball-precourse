package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DistinctDigitsParserTest {

	@ParameterizedTest
	@ValueSource(strings = {"123", " 123 "})
	void parseInput(String input) {
		List<Integer> digits = DistinctDigitsParser.parseInput(input);
		assertThat(digits).containsExactly(1, 2, 3);
	}
}
