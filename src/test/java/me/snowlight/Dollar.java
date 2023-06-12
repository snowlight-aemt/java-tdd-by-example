package me.snowlight;

class Dollar extends Money {
    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public Money times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }
}
