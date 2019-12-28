package io.bion.common.config;

import java.util.Optional;

public interface IConfigHandler {
    Optional<Byte> getByte (Config<Byte> config);

    Optional<Short> getShort (Config<Short> config);

    Optional<Long> getLong (Config<Long> config);

    Optional<Double> getDouble (Config<Double> config);

    Optional<Float> getFloat (Config<Float> config);

    Optional<Integer> getInteger (Config<Integer> config);

    Optional<Boolean> getBoolean (Config<Boolean> config);

    Optional<String> get (Config<String> config);
}
