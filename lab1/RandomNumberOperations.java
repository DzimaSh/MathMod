package lab1;

import generator.impl.GeneralizedMultiplicativeMethod;
import generator.Generator;
import generator.impl.MultiplicativeCongruentialGenerator;

public class RandomNumberOperations {
    public static <T extends Number> T generateNumber(Generator<T> numberGenerator, long requiredIterations) {
        numberGenerator.reset();
        T result = null;
        for (long i = 0; i < requiredIterations; ++i) {
            result = numberGenerator.get();
        }
        return result;
    }

    public static void partA(long seed, long constant, long modulo) {
        System.out.println("Part A");
        Generator<Double> mcg1 = new MultiplicativeCongruentialGenerator<>(seed, constant, modulo);
        System.out.println("First number: " + generateNumber(mcg1, 1L));
        System.out.println("Fifteenth number: " + generateNumber(mcg1, 15L));
        System.out.println("1000th number: " + generateNumber(mcg1, 1000L));
    }

    public static void partB(long seed1, long constant1, long modulo1, long seed2, long constant2, long modulo2, int size) {
        System.out.println("Part B");
        MultiplicativeCongruentialGenerator<Double> mcg1 = new MultiplicativeCongruentialGenerator<>(seed1, constant1, modulo1);
        MultiplicativeCongruentialGenerator<Double> mcg2 = new MultiplicativeCongruentialGenerator<>(seed2, constant2, modulo2);
        Generator<Double> gmm1 = new GeneralizedMultiplicativeMethod<>(mcg1, mcg2, size);
        System.out.println("First number: " + generateNumber(gmm1, 1L));
        System.out.println("Second number: " + generateNumber(gmm1, 15L));
        System.out.println("1000th number: " + generateNumber(gmm1, 1000L));
    }

    public static void additionalOperation7(long seed, long constant, long modulo) {
        System.out.println("Additional Operation 7");
        MultiplicativeCongruentialGenerator<Double> mcg1 = new MultiplicativeCongruentialGenerator<>(seed, constant, modulo);
        System.out.println("First number: " + generateNumber(mcg1, 1L));
        System.out.println((modulo + 1) + "th number: " + generateNumber(mcg1, modulo + 1));
    }

    public static void additionalOperation8(long seed1, long constant1, long modulo1, long seed2, long constant2, long modulo2, int size) {
        System.out.println("Additional Operation 8");
        MultiplicativeCongruentialGenerator<Double> mcg1 = new MultiplicativeCongruentialGenerator<>(seed1, constant1, modulo1);
        MultiplicativeCongruentialGenerator<Double> mcg2 = new MultiplicativeCongruentialGenerator<>(seed2, constant2, modulo2);
        GeneralizedMultiplicativeMethod<Double> gmm1 = new GeneralizedMultiplicativeMethod<>(mcg1, mcg2, size);
        System.out.println("First number: " + generateNumber(gmm1, 1L));
        System.out.println((modulo1 + 1) + "th number: " + generateNumber(gmm1, modulo1 + 2));
    }

    public static void main(String[] args) {
        long seed1 = 296454621L, constant1 = 48840859L, modulo1 = (1L << 31);
        long seed2 = 302711857L, constant2 = 37330745L, modulo2 = (1L << 31);
        int size = 64;
        partA(seed1, constant1, modulo1);
        partB(seed1, constant1, modulo1, seed2, constant2, modulo2, size);
        additionalOperation7(seed1, constant1, modulo1);
        additionalOperation8(seed1, constant1, modulo1, seed2, constant2, modulo2, size);
    }
}

