package lab2;

import generator.DiscreteGenerator;
import generator.distribution.BernoulliDistribution;
import generator.distribution.BinomialDistribution;
import generator.distribution.GeometricDistribution;
import generator.distribution.PoissonDistribution;

import static util.Util.test;

public class RandomDiscrete {

    public static void main(String[] args) {
        testBinomial();
        testBernoulli();
        testGeometric();
        testPoisson();
    }

    private static void testBinomial() {
        int n = 6;
        double p = 0.75;
        DiscreteGenerator binomial = new BinomialDistribution(n, p);
        test("Binomial distribution test", binomial, n * p, n * p * (1 - p));
    }

    private static void testBernoulli() {
        double p = 0.2;
        DiscreteGenerator bernoulli = new BernoulliDistribution(p);
        test("Bernoulli distribution test", bernoulli, p, p * (1 - p));
    }

    private static void testGeometric() {
        double p = 0.9;
        DiscreteGenerator geometric = new GeometricDistribution(p);
        test("Geometric distribution test", geometric, 1 / p, (1 - p) / (p * p));
    }

    private static void testPoisson() {
        double lambda = 0.7;
        DiscreteGenerator poisson = new PoissonDistribution(lambda);
        test("Poisson distribution test", poisson, lambda, lambda);
    }
}
