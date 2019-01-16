package com.blue.fish.se.socket.udp.base;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.UUID;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
public class DatagramProvider {

    public static void main(String[] args) throws Exception {
        String sn = UUID.randomUUID().toString();
        Provider provider = new Provider(sn);
        provider.start();

        System.in.read();
        provider.exit();
    }

    static class Provider extends Thread {
        private final String sn;
        private boolean done = false;
        private DatagramSocket ds = null;

        public Provider(String sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            System.out.println("UDP Provider Started.");

            try {
                ds = new DatagramSocket(20000);

                while (!done) {
                    final byte[] buf = new byte[512];
                    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

                    ds.receive(receivePack);

                    String ip = receivePack.getAddress().getHostAddress();
                    int port = receivePack.getPort();
                    int dataLen = receivePack.getLength();
                    String data = new String(receivePack.getData(), 0, dataLen);

                    System.out.println("UDP Provider receive from ip:" + ip + "\t port:" + port + "\t data:" + data);

                    int responsePort = MessageCreator.parsePort(data);
                    if (responsePort != -1) {
                        String responseData = MessageCreator.buildWithSn(sn);
                        byte[] responseDataBytes = responseData.getBytes();

                        DatagramPacket responsePacket = new DatagramPacket(responseDataBytes, responseDataBytes.length,
                                receivePack.getAddress(), responsePort);

                        ds.send(responsePacket);
                    }
                }
            } catch (Exception e) {

            } finally {
                close();
            }
            System.out.println("UDP Provider finished");
        }

        void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        void exit() {
            done = true;
            close();
        }
    }
}
