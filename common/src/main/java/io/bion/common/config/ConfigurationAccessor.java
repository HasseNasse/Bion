package io.bion.common.config;

import java.util.Optional;

public interface ConfigurationAccessor {
    Optional<Byte> getByte (String key);

    Optional<Short> getShort (String key);

    Optional<Integer> getInteger (String key);

    Optional<Boolean> getBoolean (String key);

    Optional<Long> getLong (String key);

    Optional<Double> getDouble (String key);

    Optional<Float> getFloat (String key);

    Optional<String> get (String key);
}
