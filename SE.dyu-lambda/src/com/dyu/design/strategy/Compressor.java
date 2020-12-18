package com.dyu.design.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Compressor {
    private final CompressionStrategy compressionStrategy;

    public Compressor(CompressionStrategy strategy) {
        compressionStrategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        OutputStream outputStream = new FileOutputStream(outFile);
        Files.copy(inFile, compressionStrategy.compress(outputStream));
    }

    public static void main(String[] args) {
        //Compressor compressor = new Compressor(new GzipCompressionStrategy());
        //compressor.compress(inFile, outFile);

        //Compressor compressor = new Compressor(new ZipCompressionStrategy());
        //compressor.compress(inFile, outFile);
    }
}
