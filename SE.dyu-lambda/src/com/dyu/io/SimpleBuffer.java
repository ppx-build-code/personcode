package com.dyu.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author dyu
 * @date 2018/10/25
 */
public class SimpleBuffer {

    public static void read(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);

        String s = new String(buffer.array());
        System.out.println(s);

    }

    public static void write(String path) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
    }

    public static void copy(String desc, String aid) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(desc);
        FileChannel fis = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fis.read(buffer);

        FileOutputStream fileOutputStream = new FileOutputStream(aid);
        FileChannel fos = fileOutputStream.getChannel();
        buffer.flip();
        fos.write(buffer);
    }

    public static void main(String[] args) throws IOException {
        read("/Users/yudi/personfile/workspaces/personcode/SE.dyu-lambda/src/com/dyu/design/template/LoanApplication.java");
        copy("/Users/yudi/personfile/workspaces/personcode/SE.dyu-lambda/src/com/dyu/design/template/LoanApplication.java", "./hello.txt");
    }
}
