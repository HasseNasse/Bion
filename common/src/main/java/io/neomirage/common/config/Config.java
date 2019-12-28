package io.neomirage.common.config;

import java.util.function.Supplier;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public class Config<T> {
    private final String key;
    private T value;
    private final Supplier<T> configSupplier;
    private boolean isDirty;

    /*Constructor*/
    public Config (final String key, final Supplier<T> configSupplier) {
        this.key = key;
        this.configSupplier = configSupplier;
    }

    /*Getter*/
    String getKey () {
        return key;
    }

    T getValue () {
        if (value == null || isDirty) {
            // Load the configuration
            loadConfiguration();
        }
        return value;
    }

    /*Setter*/
    void setDirty (final boolean dirty) {
        isDirty = dirty;
    }

    /**
     * Runs the supplier functional interface and loads the
     * config-data to the type.
     */
    private void loadConfiguration () {
        // Call the supplier functional interface
        value = configSupplier.get();
    }
}
