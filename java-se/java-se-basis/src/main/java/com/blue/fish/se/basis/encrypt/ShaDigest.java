package com.blue.fish.se.basis.encrypt;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA的摘要算法
 *
 * @author bluefish 2019-06-22
 * @version 1.0.0
 */
public class ShaDigest {

    private static void jdkSha1(String src) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA");
        sha.update(src.getBytes());
        System.out.println("jdk SHA-1" + Hex.encodeHexString(sha.digest()));
    }

    private static void bcSha1(String src) throws NoSuchAlgorithmException {
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0 , src.getBytes().length);
        byte[] sha1 = new byte[digest.getDigestSize()];
        digest.doFinal(sha1, 0);
        System.out.println("bc SHA-1" + org.bouncycastle.util.encoders.Hex.toHexString(sha1));
    }
}
