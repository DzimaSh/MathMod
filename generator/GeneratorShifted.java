package generator;

import generator.Generator;

class GeneratorShifted<T extends Number> implements Generator<T> {
    private final Generator<T> generator;
    private final T shift;

    public GeneratorShifted(Generator<T> generator, T shift) {
        this.generator = generator;
        this.shift = shift;
    }

    @Override
    public T get() {
        return (T)(Double.valueOf(generator.get().doubleValue() - shift.doubleValue()));
    }
}
