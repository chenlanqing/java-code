package com.blue.fish.se.socket.channel.client;

import com.blue.fish.se.socket.bean.ServerInfo;

import java.io.IOException;


/**
 * @author bluefish 2019-01-17
 * @version 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ServerInfo info = UDPSearcher.searchServer(10000);
        System.out.println("Server:" + info);

        if (info != null) {
            try {
                TCPClient.linkWith(info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
