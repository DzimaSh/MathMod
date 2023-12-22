package generator.distribution;

public class BernoulliDistribution extends BinomialDistribution {

    public BernoulliDistribution(double probabilityOfSuccess) {
        super(1, probabilityOfSuccess);
    }

    @Override
    public Integer get() {
        return super.get();
    }
}
