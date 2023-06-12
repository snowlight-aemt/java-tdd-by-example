package me.snowlight;

class Dollar extends Money {

    public Dollar(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    @Override
    public Money times(int multiplier) {
        return Money.dollar(this.amount * multiplier);
    }
}
