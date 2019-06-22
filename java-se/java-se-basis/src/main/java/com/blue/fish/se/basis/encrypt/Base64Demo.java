package com.blue.fish.se.basis.encrypt;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author bluefish 2019-06-21
 * @version 1.0.0
 */
public class Base64Demo {

    public static void main(String[] args) throws IOException {
        String src = "Hello Security";
        jdkBase64(src);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        commonCodecBase64(src);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        bouncyCastleBase64(src);
    }

    private static void bouncyCastleBase64(String src){
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encoder:" + new String(encode));

        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("decoder:" + new String(decode));

    }

    private static void commonCodecBase64(String src) {
        byte[] bytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encoder:" + new String(bytes));

        byte[] decode = Base64.decodeBase64(bytes);
        System.out.println("decoder:" + new String(decode));

    }

    private static void jdkBase64(String src) throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());

        System.out.println("encoder:" + encode);

        BASE64Decoder decoder = new BASE64Decoder();
        System.out.println("decoder:" + new String(decoder.decodeBuffer(encode)));
    }
}
