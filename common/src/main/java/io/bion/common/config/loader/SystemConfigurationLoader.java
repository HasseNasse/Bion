package io.bion.common.config.loader;

import io.bion.common.config.ConfigurationAccessor;

import java.util.Optional;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public enum SystemConfigurationLoader implements ConfigurationLoader, ConfigurationAccessor {
    INSTANCE;

    public static final int ORDINAL = 400;

    //Initialize Loader Singleton
    SystemConfigurationLoader () {
        initialize();
    }

    @Override
    public void initialize () {
        // Intentionally left blank
    }

    @Override
    public Optional<Byte> getByte (final String key) {
        final var value = get(key);
        return value.map(Byte::valueOf);
    }

    @Override
    public Optional<Short> getShort (final String key) {
        final var value = get(key);
        return value.map(Short::valueOf);
    }

    @Override
    public Optional<Integer> getInteger (final String key) {
        final var value = get(key);
        return value.map(Integer::valueOf);
    }

    @Override
    public Optional<Boolean> getBoolean (final String key) {
        final var value = get(key);
        return value.map(Boolean::valueOf);
    }

    @Override
    public Optional<Long> getLong (final String key) {
        final var value = get(key);
        return value.map(Long::valueOf);
    }

    @Override
    public Optional<Double> getDouble (final String key) {
        final var value = get(key);
        return value.map(Double::valueOf);
    }

    @Override
    public Optional<Float> getFloat (final String key) {
        final var value = get(key);
        return value.map(Float::valueOf);
    }

    @Override
    public Optional<String> get (final String key) {
        final var value = getSystemProperty(key);
        return value.map(String::valueOf);
    }

    private Optional<String> getSystemProperty (final String key) {
        return Optional.ofNullable(System.getProperty(key));
    }
}
