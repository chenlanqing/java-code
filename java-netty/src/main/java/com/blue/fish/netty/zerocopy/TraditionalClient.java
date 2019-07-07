package com.blue.fish.netty.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author bluefish 2019-07-06
 * @version 1.0.0
 */
public class TraditionalClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8899);

        String fileName = "/Users/bluefish/Documents/notes/e-book/tomcat架构解析.pdf";

        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount = 0;
        long total = 0;

        long start = System.currentTimeMillis();

        while ((readCount = inputStream.read()) > 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("发送字节数：" + total + "，耗时" + (System.currentTimeMillis() - start));

        inputStream.close();
        socket.close();
    }
}
