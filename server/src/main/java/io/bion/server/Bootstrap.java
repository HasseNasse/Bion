package io.bion.server;


import io.bion.common.config.ConfigHandler;
import io.bion.common.config.Configurations;
import io.undertow.Undertow;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class Bootstrap {
    private static final ConfigHandler config = ConfigHandler.INSTANCE;
    private static final String SERVER_TITLE =
            "\n" +
                    "██████╗░██╗░█████╗░███╗░░██╗\n" +
                    "██╔══██╗██║██╔══██╗████╗░██║\n" +
                    "██████╦╝██║██║░░██║██╔██╗██║\n" +
                    "██╔══██╗██║██║░░██║██║╚████║\n" +
                    "██████╦╝██║╚█████╔╝██║░╚███║\n" +
                    "╚═════╝░╚═╝░╚════╝░╚═╝░░╚══╝";

    public static void main (final String[] args) throws Exception {
        bootstrap();
    }

    /**
     * Bootstraps the Web server
     *
     * @throws NoSuchAlgorithmException
     */
    private static void bootstrap () throws NoSuchAlgorithmException {
        final var httpPort = config.getShort(Configurations.HTTP_PORT.getKey())
                .orElseGet(() -> (short) 8080);
        final var httpsPort = config.getShort(Configurations.HTTPS_PORT.getKey())
                .orElseGet(() -> (short) 8084);
        //TODO: Add sensible default values for # threads and buffer size
        final var ioThreads = config.getByte(Configurations.IO_THREADS.getKey())
                .orElseGet(() -> (byte) 10);
        final var bufferSize = config.getByte(Configurations.BUFFER_SIZE.getKey())
                .orElseGet(() -> (byte) 10);

        // Initialise server
        final Undertow server = Undertow.builder()
                .addHttpListener(httpPort, "localhost")
                .addHttpsListener(httpsPort, "localhost", SSLContext.getDefault())
                .setIoThreads(ioThreads)
                .setBufferSize(bufferSize)
                .build();

        System.out.println(SERVER_TITLE);
        // Start server
        server.start();
    }
}
