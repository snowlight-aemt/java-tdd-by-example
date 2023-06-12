package me.snowlight;

abstract class Money {
    protected int amount;

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    public abstract Money times(int amount);

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                    && getClass().equals(money.getClass());
    }
}
