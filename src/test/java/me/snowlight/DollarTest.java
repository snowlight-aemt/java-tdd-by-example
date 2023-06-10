package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DollarTest {

    @DisplayName("Dollar 곱셈, Dollar 불변성 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(3)).isEqualTo(new Dollar(15));
    }

    @DisplayName("Dollar 동시성 | equals")
    @Test
    void testEquality() {
        // TODO 삼각측량 전략
        // * 두 개 이상의 테스트 코드로 일반화
        // * 더 이상 상수로 테스트를 성공 시킬 수 없다. (동치성을 일반화)
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
        assertThat(new Dollar(5)).isNotEqualTo(new Franc(5));
    }

}