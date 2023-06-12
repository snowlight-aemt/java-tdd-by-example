package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {
    @DisplayName("Franc 곱셈, Franc 불변성 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Money five = Money.franc(5);
        assertThat(five.times(2)).isEqualTo(Money.franc(10));
        assertThat(five.times(3)).isEqualTo(Money.franc(15));
    }

    @DisplayName("Franc 동시성 | equals")
    @Test
    void testEquality() {
        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(5)).isNotEqualTo(Money.franc(6));
        assertThat(Money.franc(5)).isNotEqualTo(Money.dollar(5));
    }

    @DisplayName("통화 단위 CHF")
    @Test
    public void testCurrency() {
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }
}
