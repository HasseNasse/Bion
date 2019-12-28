package io.neomirage.common.config;

import java.util.Optional;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public enum ConfigHandler implements IConfigHandler {
    INSTANCE;

    @Override
    public Optional<Byte> getByte (final Config<Byte> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<Short> getShort (final Config<Short> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<Long> getLong (final Config<Long> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<Double> getDouble (final Config<Double> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<Float> getFloat (final Config<Float> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<Integer> getInteger (final Config<Integer> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<Boolean> getBoolean (final Config<Boolean> config) {
        return Optional.ofNullable(config.getValue());
    }

    @Override
    public Optional<String> get (final Config<String> config) {
        return Optional.ofNullable(config.getValue());
    }
}
