package com.blue.fish.se.socket.point.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bluefish 2019-01-16
 * @version 1.0.0
 */
public class TCPServer {

    private final int port;
    private ClientListener mListener;

    public TCPServer(int port) {
        this.port = port;
    }

    public boolean start() {
        try {
            ClientListener listener = new ClientListener(port);
            mListener = listener;
            listener.start();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void stop() {
        if (mListener != null) {
            mListener.exit();
        }
    }

    private static class ClientListener extends Thread {
        private ServerSocket server;
        private boolean done = false;

        public ClientListener(int port) throws IOException {
            server = new ServerSocket(port);
            System.out.println("服务器信息：" + server.getInetAddress() + " P:" + server.getLocalPort());
        }

        @Override
        public void run() {
            super.run();

            System.out.println("服务器准备就绪～");
            // 等待客户端连接
            do {
                // 得到客户端
                Socket client;

                try {
                    client = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }

                // 客户端构建异步线程
                ClientHandler clientHandler = new ClientHandler(client);

                // 启动线程
                clientHandler.start();

            } while (!done);
        }

        void exit() {
            done = true;
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private boolean flag = true;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("新客户端连接：" + socket.getInetAddress() + " P:" + socket.getPort());

            try {
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());

                InputStream inputStream = socket.getInputStream();
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(inputStream));

                do {
                    String str = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        // 回送
                        socketOutput.println("bye");
                    } else {
                        // 打印到屏幕。并回送数据长度
                        System.out.println(str);
                        socketOutput.println("回送：" + str.length());
                    }
                } while (flag);

                socketOutput.close();
                socketInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 连接关闭
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端已退出：" + socket.getInetAddress() + " P:" + socket.getPort());
        }
    }
}
