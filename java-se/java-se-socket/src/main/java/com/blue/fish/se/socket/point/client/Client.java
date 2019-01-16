package com.blue.fish.se.socket.point.client;

import com.blue.fish.se.socket.bean.ServerInfo;

/**
 * @author bluefish 2019-01-16
 * @version 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ServerInfo info = UDPSearcher.searchServer(10000);
        System.out.println("Server:" + info);

        if (info != null) {
            try {
                TCPClient.linkWith(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
