package me.snowlight;


public interface Expression {
    Money reduce(Bank bank, String currency);
}
