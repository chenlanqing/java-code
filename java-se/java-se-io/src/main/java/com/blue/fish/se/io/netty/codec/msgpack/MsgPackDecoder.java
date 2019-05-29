package com.blue.fish.se.io.netty.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * MessagePack解码器
 *
 * @author bluefish 2018/7/25
 * @version 1.0.0
 */
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int len = byteBuf.readableBytes();
        byte[] array = new byte[len];
        byteBuf.getBytes(byteBuf.readerIndex(), array, 0, len);
        MessagePack messagePack = new MessagePack();
        list.add(messagePack.read(array));
    }
}
