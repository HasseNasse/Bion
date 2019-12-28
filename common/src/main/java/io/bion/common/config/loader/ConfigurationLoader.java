package io.bion.common.config.loader;

public interface ConfigurationLoader {

    /**
     * Each loader has a specified ordinal, which is used to determine the importance of the values taken
     * from the associated Loader. A higher ordinal means the values taken from this ConfigurationLoader
     * will override values from lower-priority Loaders.
     */
    public static final int ORDINAL = 100;

    void initialize ();
}
