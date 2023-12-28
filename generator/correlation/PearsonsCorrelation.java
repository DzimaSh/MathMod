package generator.correlation;

public class PearsonsCorrelation {
    public double calculateCorrelation(double[] xs, double[] ys) {
        if (xs.length != ys.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        double xMean = calculateMean(xs);
        double yMean = calculateMean(ys);

        double numerator = 0.0;
        for (int i = 0; i < xs.length; i++) {
            numerator += (xs[i] - xMean) * (ys[i] - yMean);
        }

        double denominator = Math.sqrt(calculateVariance(xs, xMean) * calculateVariance(ys, yMean));

        return numerator / denominator;
    }

    private double calculateMean(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    private double calculateVariance(double[] values, double mean) {
        double sum = 0.0;
        for (double value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return sum;
    }
}
