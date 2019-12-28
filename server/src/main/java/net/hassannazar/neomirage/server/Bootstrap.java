package net.hassannazar.neomirage.server;

import org.eclipse.jetty.server.Server;

public class Bootstrap {
    public static void main (String[] args) throws Exception {
        // Initiate Server
        Server server = new Server(8080);

        // Start server
        server.start();
        server.join();
    }
}
