package com.blue.fish.netty.codec.msgpack;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bluefish 2018/7/25
 * @version 1.0.0
 */
public class MsgPackDemo {

    public static void main(String[] args) throws Exception {
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("google");
        src.add("facebook");

        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(src);
        List<String> read = messagePack.read(raw, Templates.tList(Templates.TString));
        System.out.println(read);
    }
}
