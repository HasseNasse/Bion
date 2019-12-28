package io.bion.common.config;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public enum Configurations {
    HTTP_PORT("server.config.http.port"),
    HTTPS_PORT("server.config.https.port"),
    IO_THREADS("server.config.io.thread.count"),
    BUFFER_SIZE("server.config.buffer.size");

    String key;

    public String getKey () {
        return key;
    }

    Configurations (final String key) {
        this.key = key;
    }
}
