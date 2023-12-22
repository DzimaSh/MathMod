package generator.distribution;

import generator.DiscreteGenerator;

import java.util.Random;

public class BinomialDistribution implements DiscreteGenerator {
    private final int numberOfTrials;
    private final double probabilityOfSuccess;
    private final Random random;

    public BinomialDistribution(int numberOfTrials, double probabilityOfSuccess) {
        this.numberOfTrials = numberOfTrials;
        this.probabilityOfSuccess = probabilityOfSuccess;
        random = new Random();
    }

    @Override
    public Integer get() {
        int successes = 0;
        for (int i = 0; i < numberOfTrials; ++i) {
            if (random.nextDouble() < probabilityOfSuccess) {
                successes++;
            }
        }
        return successes;
    }
}