package generator.impl;

import generator.Generator;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedMultiplicativeMethod<T extends Number> implements Generator<T> {
    private final Generator<T> primaryGenerator;
    private final Generator<T> secondaryGenerator;
    private List<T> valueTable = new ArrayList<>();
    private final int tableSize;

    public GeneralizedMultiplicativeMethod(Generator<T> primary, Generator<T> secondary, int size) {
        primaryGenerator = primary;
        secondaryGenerator = secondary;
        tableSize = size;
        populateTable();
    }

    private void populateTable() {
        primaryGenerator.reset();
        secondaryGenerator.reset();
        valueTable = new ArrayList<>(tableSize);
        for (int i = 0; i < tableSize; ++i) {
            valueTable.add(primaryGenerator.get());
        }
    }

    @Override
    public T get() {
        int index = (int) (secondaryGenerator.get().doubleValue() * tableSize);
        T output = valueTable.get(index);
        valueTable.set(index, primaryGenerator.get());
        return output;
    }

    @Override
    public void reset() {
        populateTable();
    }
}
