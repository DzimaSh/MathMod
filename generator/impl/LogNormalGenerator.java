package generator.impl;

public class LogNormalGenerator<T extends Number> extends NormalGenerator<T> {
    public LogNormalGenerator(T normalExpectation, T normalVariance, int N) {
        super(normalExpectation, normalVariance, N);
    }

    @Override
    public T get() {
        return (T) Double.valueOf(Math.exp(super.get().doubleValue()));
    }
}
