package com.dyu.write_flush;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author dyu 2020/12/9 19:13
 */
public class WriteAndFlushDemo {


    public void server(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new FixedLengthFrameDecoder(10))
                                .addLast(new ResponseSampleEncoder())
                                .addLast(new RequestSampleDecoder());
                    }
                });
        ChannelFuture future = serverBootstrap.bind(port).sync();
        future.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }

    public class ResponseSampleEncoder extends MessageToByteEncoder<ResponseSample> {

        protected void encode(ChannelHandlerContext channelHandlerContext, ResponseSample msg, ByteBuf byteBuf) throws Exception {
            if (null != msg) {
                System.out.println(msg.toString());
                byteBuf.writeBytes(msg.getCode().getBytes());
                byteBuf.writeBytes(msg.getData().getBytes());
                byteBuf.writeLong(msg.getTime());
            }
        }
    }

    public class RequestSampleDecoder extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String data = ((ByteBuf) msg).toString(CharsetUtil.UTF_8);
            System.out.println(data);
            ResponseSample response = new ResponseSample("ok", data, System.currentTimeMillis());
            ctx.channel().writeAndFlush(response);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new WriteAndFlushDemo().server(8888);
    }










    public class ResponseSample {
        private String code;
        private String data;
        private long time;

        @Override
        public String toString() {
            return "ResponseSample{" +
                    "code='" + code + '\'' +
                    ", data='" + data + '\'' +
                    ", time=" + time +
                    '}';
        }

        public ResponseSample(String code, String data, long time) {
            this.code = code;
            this.data = data;
            this.time = time;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }
}
