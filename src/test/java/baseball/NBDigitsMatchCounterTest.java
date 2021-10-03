package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NBDigitsMatchCounterTest {

	private NBDigitsMatchCounter matchCounter;

	@BeforeEach
	void setUp() {
		matchCounter = new NBDigitsMatchCounter();
	}

	@Test
	void count() {
		NBDigits hidden = NBDigits.build("123");
		NBDigits tried = NBDigits.build("137");

		NBDigitsMatchCounter.Result result = matchCounter.count(hidden, tried);

		assertThat(result.getCountStrike()).isEqualTo(1);
		assertThat(result.getCountBall()).isEqualTo(1);
		assertThat(result.getCountNothing()).isEqualTo(1);
	}
}
