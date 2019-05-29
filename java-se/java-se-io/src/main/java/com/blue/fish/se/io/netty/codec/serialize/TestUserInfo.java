package com.blue.fish.se.io.netty.codec.serialize;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author bluefish 2018/6/10
 * @version 1.0.0
 */
@Slf4j
public class TestUserInfo {

    public static void main(String[] args) throws Exception {
        UserInfo info = new UserInfo();
        info.buildUserID(100).buildUserName("Welcome to Netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        log.info("The jdk serializable length is : {}" , b.length);
        bos.close();
        log.info("-------------------------------------");
        log.info("The byte array serializable length is : {}", info.codeC().length);
    }
}
