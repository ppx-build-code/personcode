package com.dyu.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.AsciiString;

import java.util.Objects;

/**
 * @author dyu
 * @date 2019/05/03
 */
public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;

    @Override
    public void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        System.out.println("class -> " + fullHttpRequest.getClass().getName());
        System.out.println("content -> " + fullHttpRequest.content().toString());

        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK, Unpooled.wrappedBuffer("hello world".getBytes()));

        HttpHeaders httpHeaders = response.headers();
        httpHeaders.add(HttpHeaderNames.CONTENT_TYPE, contentType);
        httpHeaders.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        httpHeaders.add(HttpHeaderNames.KEEP_ALIVE, HttpHeaderValues.KEEP_ALIVE);

        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

        fullHttpRequest.release();



    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        if(null != cause) cause.printStackTrace();
        ctx.close();
    }
}
