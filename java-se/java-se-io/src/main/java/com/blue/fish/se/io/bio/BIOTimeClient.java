package com.blue.fish.se.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 同步阻塞IO-客户端
 *
 * @author bluefish 2018/5/29
 * @version 1.0.0
 */
public class BIOTimeClient {
    public static void main(String[] args) {
        int port = 8080;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1", port);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("QUERY TIME ORDER");

            System.out.println("Send order 2 server success");
            String response = in.readLine();
            System.out.println("Now is:" + response);
        } catch (IOException e) {
        }
    }
}
