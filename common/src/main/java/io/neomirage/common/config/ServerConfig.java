package io.neomirage.common.config;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public class ServerConfig {

    /*IO_THREADS*/
    public static final Config<Byte> IO_THREADS = new Config<>(ServerConfig::loadIoThreadsConfig);

    private static byte loadIoThreadsConfig () {
        return 10;
    }

    /*BUFFER_SIZE*/
    public static final Config<Byte> BUFFER_SIZE = new Config<>(ServerConfig::loadBufferSizeConfig);

    private static byte loadBufferSizeConfig () {
        return 10;
    }

}
