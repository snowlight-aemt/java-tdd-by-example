package me.snowlight;

class Franc extends Money {

    private final String currency;

    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    @Override
    public Money times(int multiplier) {
        return Money.franc(this.amount * multiplier);
    }
}
