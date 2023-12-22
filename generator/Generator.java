package generator;

public interface Generator<T extends Number> {
    T get();

    default void reset() {}
}
