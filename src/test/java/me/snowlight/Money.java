package me.snowlight;

class Money {
    protected int amount;

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                    && getClass().equals(money.getClass());
    }
}
