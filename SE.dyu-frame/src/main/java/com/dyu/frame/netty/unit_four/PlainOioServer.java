package com.dyu.frame.netty.unit_four;

import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dyu 2019.05.08
 */
public class PlainOioServer {

    private int port;

    public void serve() throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);

        try {
            for (; ; ) {

                final Socket socket = serverSocket.accept();
                System.out.println("accepted connection from " + socket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        OutputStream out;
                        try {
                            out = socket.getOutputStream();
                            out.write("Hi! \r\n".getBytes(CharsetUtil.UTF_8));
                            out.flush();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (!socket.isClosed()) {
                                    socket.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
