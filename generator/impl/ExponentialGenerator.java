package generator.impl;

import generator.Generator;

import java.util.Random;

public class ExponentialGenerator<T extends Number> implements Generator<T> {
    private final double lambda;
    private final Random gen;

    public ExponentialGenerator(double lambda) {
        this.lambda = lambda;
        this.gen = new Random();
    }

    @Override
    public T get() {
        return (T) Double.valueOf(-Math.log(gen.nextDouble()) / lambda);
    }
}
