package generator;

public class GeneratorSquared<T extends Number> implements Generator<T> {
    private final Generator<T> generator;

    public GeneratorSquared(Generator<T> generator) {
        this.generator = generator;
    }

    @Override
    public T get() {
        double temp = generator.get().doubleValue();
        return (T)(Double.valueOf(temp * temp));
    }
}
