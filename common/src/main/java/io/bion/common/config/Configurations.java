package io.bion.common.config;

/**
 * Purpose:
 *
 * @author Hassan Nazar
 * @author www.hassannazar.net
 */
public class Configurations {

    /*CONFIG_ORDINAL*/
    public static final Config<Short> CONFIG_ORDINAL = new Config<>("server.config.ordinal",
            Configurations::loadConfigOrdinal);

    private static short loadConfigOrdinal () {
        return 100;
    }

    /*HTTP_PORT*/
    public static final Config<Short> HTTP_PORT = new Config<>("server.config.http.port",
            Configurations::loadHttpPortConfig);

    private static short loadHttpPortConfig () {
        return 8080;
    }

    /*HTTPS_PORT*/
    public static final Config<Short> HTTPS_PORT = new Config<>("server.config.https.port",
            Configurations::loadHttpsPortConfig);

    private static short loadHttpsPortConfig () {
        return 8084;
    }

    /*IO_THREADS*/
    public static final Config<Byte> IO_THREADS = new Config<>("server.config.thread.count",
            Configurations::loadIoThreadsConfig);

    private static byte loadIoThreadsConfig () {
        return 10;
    }

    /*BUFFER_SIZE*/
    public static final Config<Byte> BUFFER_SIZE = new Config<>("server.config.buffer.size",
            Configurations::loadBufferSizeConfig);

    private static byte loadBufferSizeConfig () {
        return 10;
    }

}
