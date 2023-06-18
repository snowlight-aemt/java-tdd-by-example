package me.snowlight;


public interface Expression {
    Money reduce(MoneyTest.Bank bank, String currency);
}
