package com.dyu.frame.netty.unit_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * @author dyu 2019.05.07
 */
public class BioClient {

    private Socket socket;

    public BioClient() {
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void request() {

        try {
            socket.getOutputStream().write((LocalDateTime.now().toString() + "--- hello world.").getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void response() {
        try {
            System.out.println(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BioClient bioClient = new BioClient();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    bioClient.request();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                bioClient.response();
            }
        }).start();
        // bioClient.destroy();
    }
}
