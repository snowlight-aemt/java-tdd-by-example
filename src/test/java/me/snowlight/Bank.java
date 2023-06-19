package me.snowlight;

import java.util.Hashtable;
import java.util.Map;

class Bank {
    private Map<Pair, Integer> rates = new Hashtable();

    public Money reduce(Expression source, String currency) {
//            // TODO 클래스를 명시적으로 검사하는 코드가 있을 때에는 항상 다형성을 사용하도록 바꾸는것이 좋다.는
//            if (source instanceof Money) return (Money) source.reduce(currency);
//            Sum sum = (Sum) source;

        return source.reduce(this, currency);
    }

    public void addRate(String currency, String toCurrency, int rate) {
        rates.put(new Pair(currency, toCurrency), rate);
    }

    public int rate(String from, String to) {
        if (from.equals(to))
            return 1;

        return rates.get(new Pair(from, to));
    }

    private class Pair {
        private final String from;
        private final String to;

        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
