package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {
    @DisplayName("Franc 곱셈, Franc 불변성 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Franc five = new Franc(5);
        assertThat(five.times(2)).isEqualTo(new Franc(10));
        assertThat(five.times(3)).isEqualTo(new Franc(15));
    }

    @DisplayName("Franc 동시성 | equals")
    @Test
    void testEquality() {
        assertThat(new Franc(5)).isEqualTo(new Franc(5));
        assertThat(new Franc(5)).isNotEqualTo(new Franc(6));
    }

    private static class Franc extends Money {
        public Franc(int amount) {
            this.amount = amount;
        }

        public Franc times(int multiplier) {
            return new Franc(this.amount * multiplier);
        }
    }
}
