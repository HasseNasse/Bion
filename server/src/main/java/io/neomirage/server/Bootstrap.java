package io.neomirage.server;


import io.neomirage.common.config.ConfigHandler;
import io.neomirage.common.config.ServerConfig;
import io.undertow.Undertow;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class Bootstrap {
    private static final ConfigHandler config = ConfigHandler.INSTANCE;

    public static void main (final String[] args) throws Exception {
        bootstrap();
    }

    private static void bootstrap () throws NoSuchAlgorithmException {
        final var ioThreads = config.getByte(ServerConfig.IO_THREADS)
                .orElseThrow();
        final var bufferSize = config.getByte(ServerConfig.BUFFER_SIZE)
                .orElseThrow();

        // Initialise server
        final Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .addHttpsListener(8084, "localhost", SSLContext.getDefault())
                .setIoThreads(ioThreads)
                .setBufferSize(bufferSize)
                .build();

        // Start server
        server.start();
    }
}
