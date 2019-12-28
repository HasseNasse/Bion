package io.neomirage.common.config;

import java.util.function.Supplier;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public class Config<T> {
    private T value;
    private final Supplier<T> configSupplier;

    /*Constructor*/
    public Config (final Supplier<T> configSupplier) {
        this.configSupplier = configSupplier;
    }

    /*Getter*/
    T getValue () {
        return value;
    }

    /**
     * Runs the supplier functional interface and loads the
     * config-data to the type.
     */
    void load () {
        // Call the supplier functional interface
        value = configSupplier.get();
    }
}
