package io.bion.server;


import io.bion.common.config.ConfigHandler;
import io.bion.common.config.Configurations;
import io.undertow.Undertow;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class Bootstrap {
    private static final ConfigHandler config = ConfigHandler.INSTANCE;

    public static void main (final String[] args) throws Exception {
        bootstrap();
    }

    /**
     * Bootstraps the Web server
     *
     * @throws NoSuchAlgorithmException
     */
    private static void bootstrap () throws NoSuchAlgorithmException {
        final var httpPort = config.getShort(Configurations.HTTP_PORT)
                .orElseThrow();
        final var httpsPort = config.getShort(Configurations.HTTPS_PORT)
                .orElseThrow();
        final var ioThreads = config.getByte(Configurations.IO_THREADS)
                .orElseThrow();
        final var bufferSize = config.getByte(Configurations.BUFFER_SIZE)
                .orElseThrow();

        // Initialise server
        final Undertow server = Undertow.builder()
                .addHttpListener(httpPort, "localhost")
                .addHttpsListener(httpsPort, "localhost", SSLContext.getDefault())
                .setIoThreads(ioThreads)
                .setBufferSize(bufferSize)
                .build();

        // Start server
        server.start();
    }
}
