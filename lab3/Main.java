import generator.impl.ExponentialGenerator;
import generator.Generator;
import generator.impl.LaplacianGenerator;
import generator.impl.LogNormalGenerator;
import generator.impl.LogisticGenerator;
import generator.impl.NormalGenerator;

import static util.Util.NUMBER_OF_ITERATIONS;
import static util.Util.test;

public class Main {

    public static void main(String[] args) {
        testNormal();
        testLogNormal();
        testExponential();
        testLogistic();
    }

    public static void testNormal() {
        Double expectation = 2.0;
        Double variance = 16.0;
        Generator<Double> normal = new NormalGenerator<>(expectation, variance, NUMBER_OF_ITERATIONS);
        test("Normal distribution test", normal, expectation, variance);
    }

    public static void testLogNormal() {
        double normalExpectation = 2.0;
        double normalVariance = 1.0;
        Double expectation = Math.exp(normalExpectation + normalVariance / 2);
        Double variance = (Math.exp(normalVariance) - 1) * Math.exp(2 * normalExpectation + normalVariance);
        Generator<Double> logNormal = new LogNormalGenerator<>(normalExpectation, normalVariance, NUMBER_OF_ITERATIONS);
        test("LogNormal distribution test", logNormal, expectation, variance);
    }

    public static void testExponential() {
        double lambda = 4;
        Double expectation = 1 / lambda;
        Double variance = 1 / lambda / lambda;
        Generator<Double> exponential = new ExponentialGenerator<>(lambda);
        test("Exponential distribution test", exponential, expectation, variance);
    }

    public static void testLogistic() {
        double a = 1;
        double b = 1;
        Double expectation = a;
        Double variance = b * b * Math.PI * Math.PI / 3.0;
        Generator<Double> logistic = new LogisticGenerator<>(a, b);
        test("Logistic distribution test", logistic, expectation, variance);
    }

    public static void testLaplacian() {
        double lambda = 1;
        double shift = 0;
        Double expectation = shift;
        Double variance = 2.0 / lambda / lambda;
        Generator<Double> laplacian = new LaplacianGenerator<>(lambda, shift);
        test("Laplacian distribution test", laplacian, expectation, variance);
    }

}
