package generator.distribution;

import generator.DiscreteGenerator;

import java.util.Random;

public class GeometricDistribution implements DiscreteGenerator {
    private final double successProbability;
    private final Random random;

    public GeometricDistribution(double successProbability) {
        this.successProbability = successProbability;
        random = new Random();
    }

    @Override
    public Integer get() {
        int trialsUntilSuccess = 0;
        do {
            ++trialsUntilSuccess;
        } while (!(random.nextDouble() < successProbability));
        return trialsUntilSuccess;
    }
}
