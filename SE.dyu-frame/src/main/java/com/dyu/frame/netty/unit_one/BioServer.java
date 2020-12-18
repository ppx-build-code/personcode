package com.dyu.frame.netty.unit_one;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dyu 2019.05.07
 */
public class BioServer {


    private int port;

    public BioServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket accept = null;
            try {
                accept = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter out = null;
            try {
                out = new PrintWriter(accept.getOutputStream());
                String request, response;
                assert in != null;
                while ((request = in.readLine()) != null) {
                    System.out.println(request);

                    if (request.equals("done")) {
                        break;
                    }

                    response = "fuck!!!";
                    out.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BioServer bioServer = new BioServer(8888);
        bioServer.start();
    }
}
