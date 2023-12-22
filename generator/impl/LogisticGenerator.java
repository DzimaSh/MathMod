package generator.impl;

import generator.Generator;

import java.util.Random;

public class LogisticGenerator<T extends Number> implements Generator<T> {
    private final double a;
    private final double b;
    private final Random gen;

    public LogisticGenerator(double a, double b) {
        this.a = a;
        this.b = b;
        this.gen = new Random();
    }

    @Override
    public T get() {
        double uniform = gen.nextDouble();
        return (T) Double.valueOf(a - b * Math.log((1 - uniform) / uniform));
    }
}
