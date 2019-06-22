package com.blue.fish.se.basis.encrypt;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * MD摘要算法的实现
 *
 * @author bluefish 2019-06-22
 * @version 1.0.0
 */
public class MDDigest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String src = "Hello MD Digest";

        jdkMd5(src);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        jdkMd2(src);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        bcMd4(src);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        bcMd5(src);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        ccMD5(src);
    }

    private static void jdkMd5(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(src.getBytes());
        System.out.println("JDK MD5: " + Hex.encodeHexString(digest));
    }

    private static void bcMd5(String src) {
        Digest digest = new MD5Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes, 0);
        System.out.println("BC MD5: " + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
    }

    private static void bcMd4(String src) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance("MD4");
        byte[] digest = md.digest(src.getBytes());
        System.out.println("BC MD4: " + Hex.encodeHexString(digest));

//        Digest digest = new MD4Digest();
//        digest.update(src.getBytes(), 0, src.getBytes().length);
//        byte[] md4Bytes = new byte[digest.getDigestSize()];
//        digest.doFinal(md4Bytes, 0);
//        System.out.println("BC MD4: " + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
    }

    private static void jdkMd2(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD2");
        byte[] digest = md.digest(src.getBytes());
        System.out.println("JDK MD2: " + Hex.encodeHexString(digest));
    }

    public static void ccMD5(String src) {
        System.out.println("Apache MD5: " + DigestUtils.md5Hex(src));
    }
}
