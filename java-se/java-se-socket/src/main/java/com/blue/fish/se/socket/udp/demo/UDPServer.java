package com.blue.fish.se.socket.udp.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author bluefish 2019-05-12
 * @version 1.0.0
 */
public class UDPServer {

    public static void main(String[] args) throws Exception{
        DatagramSocket server = new DatagramSocket(2000);

        byte[] recvBuf = new byte[100];

        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

        server.receive(recvPacket);

        String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
        System.out.println("Hello " + recvStr);

        int port = recvPacket.getPort();
        InetAddress addr = recvPacket.getAddress();

        String sendStr = "Hello, I am server";

        byte[] sendBuf = sendStr.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, addr, port);

        server.send(sendPacket);

        server.close();
    }

}
