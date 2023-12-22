package generator.impl;

import generator.Generator;

import java.util.Random;

public class LaplacianGenerator<T extends Number> implements Generator<T> {
    private final double lambda;
    private final double shift;
    private final Random gen;

    public LaplacianGenerator(double lambda, double shift) {
        this.lambda = lambda;
        this.shift = shift;
        this.gen = new Random();
    }

    @Override
    public T get() {
        double uniform1 = gen.nextDouble();
        double uniform2 = gen.nextDouble();
        return (T) Double.valueOf(shift + Math.log(uniform1 / uniform2) / lambda);
    }
}
