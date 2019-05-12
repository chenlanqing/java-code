package com.blue.fish.se.socket.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author bluefish 2019-05-12
 * @version 1.0.0
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();

        String sendStr = "Client";

        byte[] sendBuf = sendStr.getBytes();

        InetAddress addr = InetAddress.getByName("127.0.0.1");

        int port = 2000;

        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, addr, port);

        client.send(sendPacket);

        byte[] recvBuf = new byte[100];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

        client.receive(recvPacket);

        String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());

        System.out.println("Receive:" + recvStr);

        client.close();
    }
}
