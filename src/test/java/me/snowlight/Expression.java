package me.snowlight;


public interface Expression {
    Money reduce(Bank bank, String currency);

    Expression plus(Expression tenFrancs);

    Expression times(int multiplier);
}
