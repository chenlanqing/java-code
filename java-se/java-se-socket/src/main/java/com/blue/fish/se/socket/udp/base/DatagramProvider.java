package com.blue.fish.se.socket.udp.base;

import lombok.extern.slf4j.Slf4j;

import java.net.DatagramSocket;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
@Slf4j
public class DatagramProvider {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(20000);
    }
}
