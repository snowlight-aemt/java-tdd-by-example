package me.snowlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @DisplayName("Dollar 곱셈, Dollar 불변성 | $5 * 2 = $10")
    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @DisplayName("Money 동치성 | equals")
    @Test
    void testEquality() {
        // TODO 삼각측량 전략
        // * 두 개 이상의 테스트 코드로 일반화
        // * 더 이상 상수로 테스트를 성공 시킬 수 없다. (동치성을 일반화)
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.franc(5));

        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(5)).isNotEqualTo(Money.franc(6));
        assertThat(Money.franc(5)).isNotEqualTo(Money.dollar(5));
    }

    @DisplayName("통화 단위 USD")
    @Test
    public void testCurrency() {
        assertThat("USD").isEqualTo(Money.dollar(1).currency());
        assertThat("CHF").isEqualTo(Money.franc(1).currency());
    }

    @DisplayName("금액과 통화로 동치성 | equals")
    @Test
    void testDifferentClassEquality() {
        assertThat(new Money(10, "USD")).isEqualTo(Money.dollar(10));
        assertThat(new Money(10, "CHF")).isEqualTo(Money.franc(10));
    }

    @DisplayName("Money 더하기 연산 | $5 + $5 = $10 ")
    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(Money.dollar(10)).isEqualTo(reduced);
    }

    @DisplayName("Money 더하기 연산 | $5 + $5 => Expression")
    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);

        Sum sum = (Sum) result;
        assertThat(five).isEqualTo(sum.augend);
        assertThat(five).isEqualTo(sum.addend);
    }

    @DisplayName("Money 더하기 연산 | $3 + $4 = $7 (bank.reduce())")
    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");

        assertThat(result).isEqualTo(Money.dollar(7));
    }

    @DisplayName("Money 더하기 연산 | Bank.reduce(Money)")
    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");

        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @DisplayName("Money 통화 변경 (환율) | CHF -> USD")
    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");

        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @DisplayName("Money 통화 변경 (환율) | USD -> USD")
    @Test
    void testIdentityRate() {
        assertThat(new Bank().rate("USD", "USD")).isEqualTo(1);
    }

    @DisplayName("서로 다른 통화 더하기")
    @Test
    void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");

        assertThat(result).isEqualTo(Money.dollar(10));
    }

    @DisplayName("Sum 수식에 Money 더하기 | Sum.reduce(...)")
    @Test
    void testSumPlusMoney() {
        Money fiveBucks = Money.dollar(5);
        Money tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Expression result = bank.reduce(sum, "USD");

        assertThat(result).isEqualTo(Money.dollar(15));
    }

    @DisplayName("Sum 수식에 times 연산자")
    @Test
    void testTimesMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");

        assertThat(result).isEqualTo(Money.dollar(20));
    }

    @Test
    void testPlusSameCurrencyReturnsMoney() {
        Expression sum = Money.dollar(1).plus(Money.dollar(1));
        assertThat(sum instanceof Money).isTrue();
    }
}
