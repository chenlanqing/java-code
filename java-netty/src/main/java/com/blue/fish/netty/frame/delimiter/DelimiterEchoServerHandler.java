package com.blue.fish.netty.frame.delimiter;

import io.netty.channel.ChannelHandler;

/**
 * @author bluefish 2018/7/25
 * @version 1.0.0
 */
@ChannelHandler.Sharable
public class DelimiterEchoServerHandler { //extends SimpleChannelInboundHandler {
    int counter = 0;

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg)
//            throws Exception {
//        String body = (String) msg;
//        System.out.println("This is " + ++counter + " times receive client : ["
//                + body + "]");
//        body += "$_";
//        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//        ctx.writeAndFlush(echo);
//    }
//
//    @Override
//    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
//
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        cause.printStackTrace();
//        ctx.close();// 发生异常，关闭链路
//    }
}
