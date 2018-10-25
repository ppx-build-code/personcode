package com.dyu.design.concurrent;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dyu
 * @date 2018/09/08
 */
public class SimpleHttpServer {
    // 处理HttpRequest 的线程池
    //static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>(1);

    static String basepath;
    static ServerSocket serverSocket;
    static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasepath(String basepath) {
        if (basepath != null && new File(basepath).exists() && new File(basepath).isDirectory()) {
            SimpleHttpServer.basepath = basepath;
        }
    }

    static class HttpRequestHandler implements Runnable {
        private Socket socket;

        private HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader reader1 = null;
            BufferedReader reader2 = null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader2.readLine();

                String filePath = basepath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());

                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("Http/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jepg");
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);

                } else {
                    reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("Http/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = reader1.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (IOException e) {
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(reader1, in, reader2, out, socket);
            }
        }
    }


    private static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
