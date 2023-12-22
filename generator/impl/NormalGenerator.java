package generator.impl;

import generator.Generator;

import java.util.Random;

public class NormalGenerator<T extends Number> implements Generator<T> {
    private final int N;
    private final T expectation;
    private final T variance;
    private final Random gen;

    public NormalGenerator(T expectation, T variance, int N) {
        this.expectation = expectation;
        this.variance = variance;
        this.N = N;
        this.gen = new Random();
    }

    @Override
    public T get() {
        double result = 0;
        for (int i = 0; i < N; ++i) {
            result += gen.nextDouble();
        }
        result -= N / 2.0;
        result *= Math.sqrt(12.0 / N);
        return (T) Double.valueOf(expectation.doubleValue() + result * Math.sqrt(variance.doubleValue()));
    }
}
