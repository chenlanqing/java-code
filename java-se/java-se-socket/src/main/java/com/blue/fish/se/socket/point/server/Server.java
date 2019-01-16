package com.blue.fish.se.socket.point.server;

import com.blue.fish.se.socket.constants.TCPConstants;

/**
 * @author bluefish 2019-01-16
 * @version 1.0.0
 */
public class Server {

    public static void main(String[] args) {
        TCPServer tcpServer = new TCPServer(TCPConstants.PORT_SERVER);
        boolean isSuccess = tcpServer.start();
        if (!isSuccess) {
            System.out.println("Start TCP server failed!");
            return;
        }

        UDPProvider.start(TCPConstants.PORT_SERVER);

        try {
            System.in.read();
        } catch (Exception e) {

        }

        UDPProvider.stop();
        tcpServer.stop();

    }
}
