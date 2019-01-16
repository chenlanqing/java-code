package com.blue.fish.se.socket.search.server;

import com.blue.fish.se.socket.constants.TCPConstants;

import java.io.IOException;

/**
 * @author bluefish 2019-01-15
 * @version 1.0.0
 */
public class Server {

    public static void main(String[] args) {
        ServerProvider.start(TCPConstants.PORT_SERVER);

        try {
            //noinspection ResultOfMethodCallIgnored
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ServerProvider.stop();
    }
}
