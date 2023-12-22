package generator.impl;

import generator.Generator;

public class MultiplicativeCongruentialGenerator<T extends Number> implements Generator<T> {
    private final long initialSeed;
    private long currentSeed;
    private final long multiplier;
    private final long modulus;

    public MultiplicativeCongruentialGenerator(long seed, long multiplierConstant, long modulo) {
        initialSeed = seed;
        currentSeed = seed;
        modulus = modulo;
        multiplier = Math.max(multiplierConstant, modulo - multiplierConstant);
    }

    @Override
    public T get() {
        currentSeed *= multiplier;
        currentSeed %= modulus;
        return (T) (Double.valueOf(((double) currentSeed) / modulus));
    }

    @Override
    public void reset() {
        currentSeed = initialSeed;
    }
}
