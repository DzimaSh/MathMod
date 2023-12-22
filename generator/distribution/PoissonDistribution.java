package generator.distribution;

import generator.DiscreteGenerator;

import java.util.Random;

public class PoissonDistribution implements DiscreteGenerator {
    private final double mean;
    private final Random random;

    public PoissonDistribution(double mean) {
        this.mean = mean;
        random = new Random();
    }

    @Override
    public Integer get() {
        double expMinusMean = Math.exp(-mean);
        int k = 0;
        double product = 1;
        do {
            ++k;
            double generatedProbability = random.nextDouble();
            product *= generatedProbability;
        } while (product > expMinusMean);
        return k - 1;
    }
}
