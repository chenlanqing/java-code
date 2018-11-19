package com.blue.fish.se.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 同步阻塞IO-线程
 *
 * @author bluefish 2018/5/29
 * @version 1.0.0
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            out = new PrintWriter(this.socket.getOutputStream(), true);

            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("The time server receive order:" + body);

                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";

              out.println(currentTime);

            }
        } catch (Exception e){
            try {
                if (in != null){
                    in.close();
                }
                if (out != null){
                    out.close();
                }
                if (socket != null){
                    socket.close();
                }
            } catch (Exception e1){

            }
        }
    }
}
