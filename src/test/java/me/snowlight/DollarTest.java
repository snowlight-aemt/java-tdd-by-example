package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DollarTest {

    @DisplayName("Dollar 곱셈 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);

        assertThat(five.amount).isEqualTo(10);
    }

    private class Dollar {
        public int amount;

        public Dollar(int amount) {
            this.amount = amount;
        }

        public void times(int multiplier) {
            this.amount *= multiplier;
        }
    }
}