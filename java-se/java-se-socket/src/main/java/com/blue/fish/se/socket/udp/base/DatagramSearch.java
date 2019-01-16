package com.blue.fish.se.socket.udp.base;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
public class DatagramSearch {

    private static final int listen_port = 30000;

    public static void main(String[] args) throws Exception {
        System.out.println("UDP search Started.");
        Listener listen = listen();

        sentBroadCast();

        System.in.read();
        List<Device> devicesAndClose = listen.getDevicesAndClose();
        System.out.println(devicesAndClose);

        System.out.println("UDP search finished.");
    }

    private static Listener listen() throws Exception {
        System.out.println("UDP listen started.");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(listen_port, countDownLatch);

        listener.start();

        countDownLatch.await();
        return listener;
    }

    private static void sentBroadCast() throws Exception {
        System.out.println("UDP sentBroadCast Started.");

        // 作为搜索方，让系统自动分配端口
        DatagramSocket ds = new DatagramSocket();

        String requestData = MessageCreator.buildWithPort(listen_port);
        byte[] requestDataBytes = requestData.getBytes();
        // 构建请求实体
        DatagramPacket requestPacket = new DatagramPacket(requestDataBytes, requestDataBytes.length);
        requestPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        requestPacket.setPort(20000);

        // 发送数据
        ds.send(requestPacket);
        ds.close();

        System.out.println("UDP sentBroadCast finished");
    }

    static class Device {
        final int port;
        final String ip;
        final String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip='" + ip + '\'' +
                    ", sn='" + sn + '\'' +
                    '}';
        }
    }

    static class Listener extends Thread {
        private final int listenPort;
        private final CountDownLatch countDownLatch;
        private final List<Device> devices = new ArrayList<>();
        private boolean done = false;
        private DatagramSocket ds = null;

        public Listener(int listenPort, CountDownLatch countDownLatch) {
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();

            countDownLatch.countDown();
            try {
                ds = new DatagramSocket(listenPort);
                while (!done) {
                    final byte[] buf = new byte[512];
                    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

                    ds.receive(receivePack);

                    String ip = receivePack.getAddress().getHostAddress();
                    int port = receivePack.getPort();
                    int dataLen = receivePack.getLength();
                    String data = new String(receivePack.getData(), 0, dataLen);

                    System.out.println("UDP Search receive from ip:" + ip + "\t port:" + port + "\t data:" + data);

                    String sn = MessageCreator.parseSn(data);
                    if (sn != null) {
                        Device device = new Device(port, ip, sn);
                        devices.add(device);
                    }
                }
            } catch (Exception e) {

            } finally {
                close();
            }

            System.out.println("UDP Listener finished");

        }

        void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        public List<Device> getDevicesAndClose() {
            done = true;
            close();
            return devices;
        }
    }
}
