package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DollarTest {

    @DisplayName("Dollar 곱셈, Dollar 불변성 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @DisplayName("Dollar 동치성 | equals")
    @Test
    void testEquality() {
        // TODO 삼각측량 전략
        // * 두 개 이상의 테스트 코드로 일반화
        // * 더 이상 상수로 테스트를 성공 시킬 수 없다. (동치성을 일반화)
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.franc(5));
    }

    @DisplayName("통화 단위 USD")
    @Test
    public void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
    }

    @DisplayName("금액과 통화로 동치성 | equals")
    @Test
    void testDifferentClassEquality() {
        assertThat(new Money(10, "USD")).isEqualTo(Money.dollar(10));
    }
}