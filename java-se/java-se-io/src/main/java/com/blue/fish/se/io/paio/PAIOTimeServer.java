package com.blue.fish.se.io.paio;


import com.blue.fish.se.io.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步IO-服务端，实际上其实通过线程池来实现的
 *
 * @author bluefish 2018/5/29
 * @version 1.0.0
 */
public class PAIOTimeServer {
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

            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 10000);

            while (true){
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
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
