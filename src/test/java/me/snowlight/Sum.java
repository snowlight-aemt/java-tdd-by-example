package me.snowlight;

class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String currency) {
        int amount = this.augend.reduce(bank, currency).amount
                        + this.addend.reduce(bank, currency).amount;
        return new Money(amount, currency);
    }

    @Override
    public Expression plus(Expression tenFrancs) {
        return null;
    }
}
