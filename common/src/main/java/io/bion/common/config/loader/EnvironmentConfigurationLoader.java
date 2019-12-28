package io.bion.common.config.loader;

import io.bion.common.config.ConfigurationAccessor;

import java.util.Optional;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public enum EnvironmentConfigurationLoader implements ConfigurationLoader, ConfigurationAccessor {
    INSTANCE;

    public static final int ORDINAL = 300;

    // Initialize Loader Singleton
    EnvironmentConfigurationLoader () {
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
        final var value = getEnvironmentVariable(key);
        return value.map(String::valueOf);
    }

    /**
     * Fetches system environment variables based on the key provided.
     * <p>
     * Some operating systems allow only alphabetic characters or an underscore
     * , _, in environment variables. Other characters such as ., / etc may be
     * disallowed.
     * To accomodate for this, we search for 3 environment variables:
     * 1. Exact match (i.e. server.config.x.y.z)
     * 2. Replace . with _ (i.e. server_config_x_y_z)
     * 3. Replace non-alphanumeric characters with _ and convert to uppercase
     * (i.e. SERVER_CONFIG_X_Y_Z)
     * </p>
     *
     * @param key
     * @return
     */
    Optional<String> getEnvironmentVariable (final String key) {
        final var keys = new String[]{
                key,
                // Replace . with _ (i.e. server_config_x_y_z)
                key.replaceAll(".", "_"),
                // Replace non-alphanumeric characters with _ and convert to uppercase
                key.replaceAll(".", "_").toUpperCase()
        };

        // Iterate over all key-scenarios
        for (final String s : keys) {

            final var value = Optional.ofNullable(System.getenv(s));

            if (value.isPresent()) {
                return value;
            }

        }

        return Optional.empty();
    }
}
