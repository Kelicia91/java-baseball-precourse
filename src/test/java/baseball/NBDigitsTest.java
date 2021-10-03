package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NBDigitsTest {

	@Test
	void match() {
		NBDigits digits = NBDigits.build("123");
		assertThat(digits.match(0, 1)).isEqualTo(NBDigits.Matching.STRIKE);
		assertThat(digits.match(1, 1)).isEqualTo(NBDigits.Matching.BALL);
		assertThat(digits.match(2, 4)).isEqualTo(NBDigits.Matching.NOTHING);
	}
}
