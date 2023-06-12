package me.snowlight;

abstract class Money {
    protected int amount;

    protected String currency;

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public abstract Money times(int amount);

    public abstract String currency();

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                    && getClass().equals(money.getClass());
    }
}
