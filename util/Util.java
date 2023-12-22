package util;

import generator.Generator;
import generator.GeneratorSquared;

public class Util {

    public static final int NUMBER_OF_ITERATIONS = 10000;

    public static <T extends Number> double getExpectation(Generator<T> generator, int numberOfIteration) {
        double sum = 0;
        for (int i = 0; i < numberOfIteration; ++i) {
            sum += generator.get().doubleValue();
        }
        return sum / numberOfIteration;
    }

    public static <T extends Number> double getVariance(Generator<T> generator, int numberOfIteration) {
        double expectation = getExpectation(generator, numberOfIteration);
        GeneratorSquared<T> generatorSquared = new GeneratorSquared<>(generator);
        return getExpectation(generatorSquared, numberOfIteration) - expectation * expectation;
    }

    public static <T extends Number> String formPrompt(String metric, T actualValue, T theoreticalValue) {
        return "Actual " + metric + ": " + actualValue.toString() +
                ", theoretical " + metric + ": " + theoreticalValue.toString();
    }


    public static <T extends Number> void test(String header, Generator<T> generator, double theoreticalExpectation, double theoreticalVariance) {
        System.out.println(header);
        System.out.println(formPrompt("expectation", getExpectation(generator, NUMBER_OF_ITERATIONS), theoreticalExpectation));
        System.out.println(formPrompt("variance", getVariance(generator, NUMBER_OF_ITERATIONS), theoreticalVariance));
        System.out.println();
    }
}
