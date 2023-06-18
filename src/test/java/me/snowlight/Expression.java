package me.snowlight;


public interface Expression {
    Money reduce(String currency);
}
