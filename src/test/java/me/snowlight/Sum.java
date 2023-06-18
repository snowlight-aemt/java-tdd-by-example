package me.snowlight;

class Sum implements Expression {
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(MoneyTest.Bank bank, String currency) {
        int amount = this.augend.amount + this.addend.amount;
        return new Money(amount, currency);
    }
}
