package io.bion.common.config;

import io.bion.common.config.loader.EnvironmentConfigurationLoader;
import io.bion.common.config.loader.FileConfigurationLoader;
import io.bion.common.config.loader.SystemConfigurationLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public enum ConfigHandler implements ConfigurationAccessor {
    INSTANCE;

    private final List<ConfigurationAccessor> loaders;

    ConfigHandler () {
        // Initialize our loader list
        loaders = new ArrayList<>();

        // Bring in all loaders
        final var environmentLoader = EnvironmentConfigurationLoader.INSTANCE;
        final var systemLoader = SystemConfigurationLoader.INSTANCE;
        final var fileLoader = FileConfigurationLoader.INSTANCE;

        loaders.add(systemLoader);
        loaders.add(environmentLoader);
        loaders.add(fileLoader);
    }

    @Override
    public Optional<Byte> getByte (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getByte(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Short> getShort (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getShort(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Integer> getInteger (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getInteger(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Boolean> getBoolean (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getBoolean(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Long> getLong (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getLong(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Double> getDouble (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getDouble(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Float> getFloat (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.getFloat(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<String> get (final String key) {
        for (final ConfigurationAccessor loader : loaders) {
            final var value = loader.get(key);

            if (value.isPresent()) {
                return value;
            }
        }

        return Optional.empty();
    }
}
