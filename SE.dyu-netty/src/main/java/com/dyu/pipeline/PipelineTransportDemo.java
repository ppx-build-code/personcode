package com.dyu.pipeline;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

/**
 * @author dyu 2020/12/1 15:20
 */
public class PipelineTransportDemo {


    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline()
                        .addLast(new FixedLengthFrameDecoder(10))
                        .addLast(new SimpleInboundHandler("SimpleInboundHandler A", false))
                        .addLast(new SimpleInboundHandler("SimpleInboundHandler B", false))
                        .addLast(new SimpleInboundHandler("SimpleInboundHandler C", true));

                socketChannel.pipeline()
                        .addLast(new SimpleOutboundHandler("SimpleOutboundHandler A"))
                        .addLast(new SimpleOutboundHandler("SimpleOutboundHandler B"))
                        .addLast(new SimpleOutboundHandler("SimpleOutboundHandler C"));
            }
        }).bind(8888).sync();
    }

    public static class SimpleInboundHandler extends ChannelInboundHandlerAdapter {
        private final String name;
        private final boolean flush;

        public SimpleInboundHandler(String name, boolean flush) {
            this.name = name;
            this.flush = flush;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("inboundHandler >>>>>>>>>>>>>> " + name);
            if (flush) {
                ctx.channel().writeAndFlush(msg);
            } else {
                super.channelRead(ctx, msg);
            }
        }
    }

    public static class SimpleOutboundHandler extends ChannelOutboundHandlerAdapter {
        private final String name;

        public SimpleOutboundHandler(String name) {
            this.name = name;
        }

        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("outboundHandler >>>>>>>>>>>>> " + name);
            super.write(ctx, msg, promise);
        }
    }

}
