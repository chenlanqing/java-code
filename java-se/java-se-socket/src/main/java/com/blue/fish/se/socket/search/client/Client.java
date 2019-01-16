package com.blue.fish.se.socket.search.client;

import com.blue.fish.se.socket.bean.ServerInfo;

/**
 * @author bluefish 2019-01-15
 * @version 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ServerInfo serverInfo = ClientSearcher.searchServer(10000);

        System.out.println("Server:" + serverInfo);
    }
}
