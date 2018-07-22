package com.dyu.design.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author dyu
 * @date 2018/07/22
 */
public interface CompressionStrategy {
    OutputStream compress(OutputStream data) throws IOException;
}
