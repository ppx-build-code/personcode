package com.dyu.frame.io;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * @author dyu 2019.04.18
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket = null;
                try {
                    socket = new Socket("127.0.0.1", 3333);
                    while (true) {
                        socket.getOutputStream().write((new Date().toString() + " hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }
            }
        }).start();


    }
}
