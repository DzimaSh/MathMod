package lab1;

import generator.impl.GeneralizedMultiplicativeMethod;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import generator.Generator;
import generator.correlation.PearsonsCorrelation;
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

    public static void partA(Generator<Double> mcg) {
        System.out.println("Part A");
        System.out.println("First number: " + generateNumber(mcg, 1L));
        System.out.println("Fifteenth number: " + generateNumber(mcg, 15L));
        System.out.println("1000th number: " + generateNumber(mcg, 1000L));
    }

    public static void partB(Generator<Double> gmm1 ) {
        System.out.println("Part B");
        System.out.println("First number: " + generateNumber(gmm1, 1L));
        System.out.println("Second number: " + generateNumber(gmm1, 15L));
        System.out.println("1000th number: " + generateNumber(gmm1, 1000L));
    }

    public static void additionalOperation1(Generator<Double> generator, double epsilon) {
        System.out.println("Additional Operation 1");
        double[] sequence = new double[10000];
        for (int i = 0; i < sequence.length; ++i) {
            sequence[i] = generator.get();
        }

        double mean = Arrays.stream(sequence).average().getAsDouble();

        double pValue = chiSquareTest(
            new long[]{(long) (mean * sequence.length), (long) ((1 - mean) * sequence.length)},
            new long[]{sequence.length / 2, sequence.length / 2}
        );

        System.out.println("p-value: " + pValue);
        System.out.println("Test passed: " + (pValue > epsilon));
    }

    private static double chiSquareTest(long[] observed, long[] expected) {
        if (observed == null || expected == null) {
            throw new IllegalArgumentException("Arrays must not be null");
        }

        if (observed.length != expected.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        double chiSquare = 0.0;
        for (int i = 0; i < observed.length; i++) {
            if (expected[i] == 0) {
                throw new IllegalArgumentException("Expected value at index " + i + " is zero");
            }

            chiSquare += Math.pow(observed[i] - expected[i], 2) / expected[i];
        }

        return chiSquare;
    }

    public static void additionalOperation4(Generator<Double> generator, int tauMax) {
        System.out.println("Additional Operation 4");
        List<Double> sequence = new ArrayList<>();
        for (int i = 0; i < tauMax * 2; ++i) {
            sequence.add(generator.get());
        }

        PearsonsCorrelation correlation = new PearsonsCorrelation();
        List<Double> correlations = new ArrayList<>();
        for (int tau = 1; tau <= tauMax; ++tau) {
            double[] array1 = sequence.subList(0, tauMax).stream().mapToDouble(Double::doubleValue).toArray();
            double[] array2 = sequence.subList(tau, tauMax + tau).stream().mapToDouble(Double::doubleValue).toArray();
            double corr = correlation.calculateCorrelation(array1, array2);

            correlations.add(corr);
            System.out.println("r" + tau + " = " + corr);
        }

        saveCorrelations(correlations, "correlations.txt");
    }

    public static void saveCorrelations(List<Double> correlations, String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (Double correlation : correlations) {
                writer.println(correlation);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the correlations.");
            e.printStackTrace();
        }
    }

    public static void additionalOperation6(Generator<Double> generator) {
        System.out.println("Additional Operation 6");
        List<Double> sequence = new ArrayList<>();
        for (int i = 0; i < 20000; ++i) {
            sequence.add(generator.get());
        }
    
        for (int i = 0; i < sequence.size(); ++i) {
            for (int j = i + 1; j < sequence.size(); ++j) {
                if (Math.abs(sequence.get(i) - sequence.get(j)) < 0.00001) {
                    System.out.println("Period length: " + (j - i));
                    return;
                }
            }
        }
    }    

    public static void additionalOperation7(Generator<Double> mcg, long modulo) {
        System.out.println("Additional Operation 7");
        System.out.println("First number: " + generateNumber(mcg, 1L));
        System.out.println((modulo + 1) + "th number: " + generateNumber(mcg, modulo + 1));
    }

    public static void additionalOperation8(Generator<Double> gmm, long modulo1) {
        System.out.println("Additional Operation 8");
        System.out.println("First number: " + generateNumber(gmm, 1L));
        System.out.println((modulo1 + 1) + "th number: " + generateNumber(gmm, modulo1 + 2));
    }

    public static void main(String[] args) {
        long seed1 = 296454621L, constant1 = 48840859L, modulo1 = (1L << 31);
        long seed2 = 302711857L, constant2 = 37330745L, modulo2 = (1L << 31);
        int size = 64;

        Generator<Double> mcg1 = new MultiplicativeCongruentialGenerator<>(seed1, constant1, modulo1);
        Generator<Double> mcg2 = new MultiplicativeCongruentialGenerator<>(seed2, constant2, modulo2);
        Generator<Double> gmm1 = new GeneralizedMultiplicativeMethod<>(mcg1, mcg2, size);

        partA(mcg1);
        partB(gmm1);
        additionalOperation1(mcg1, 0.05);
        additionalOperation4(mcg1, 30);
        additionalOperation6(mcg1);
        additionalOperation7(mcg1, modulo1);
        additionalOperation8(gmm1, modulo1);
    }
}
