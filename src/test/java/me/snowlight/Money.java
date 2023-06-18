package me.snowlight;

import java.util.Objects;

class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return currency;
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(MoneyTest.Bank bank, String toCurrency) {
        int rate = bank.rate(this.currency, toCurrency);
        return new Money(this.amount / rate, toCurrency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return this.amount == money.amount
                && this.currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
