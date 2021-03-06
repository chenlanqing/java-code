package com.blue.fish.se.io.bio;


import com.blue.fish.se.io.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞-服务端
 *
 * @author bluefish 2018/5/29
 * @version 1.0.0
 */
public class BIOTimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);

            System.out.println("The time server is start in port:" + port);

            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        } finally {
            if (server != null){
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
