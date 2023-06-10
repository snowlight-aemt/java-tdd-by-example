package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DollarTest {

    @DisplayName("Dollar 곱셈, Dollar 불변성 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertThat(product.amount).isEqualTo(10);

        product = five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }

    private class Dollar {
        public int amount;

        public Dollar(int amount) {
            this.amount = amount;
        }

        public Dollar times(int multiplier) {
            return new Dollar(this.amount * multiplier);
        }
    }
}