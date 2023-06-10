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

    @DisplayName("Dollar 동시성 | equals")
    @Test
    void testEquality() {
        // TODO 삼각측량 전략
        // * 두 개 이상의 테스트 코드로 일반화
        // * 더 이상 상수로 테스트를 성공 시킬 수 없다. (동치성을 일반화)
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
    }

    private class Dollar {
        public int amount;

        public Dollar(int amount) {
            this.amount = amount;
        }

        public Dollar times(int multiplier) {
            return new Dollar(this.amount * multiplier);
        }

        @Override
        public boolean equals(Object obj) {
            Dollar dollar = (Dollar) obj;
            return this.amount == dollar.amount;
        }
    }
}