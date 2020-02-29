package com.blue.fish.se.basis.binary;

import java.util.Arrays;

/**
 * int 与 byte[] 之间的转换过程
 *
 * @author bluefish
 */
public class CovertToRadix {
    public static void main(String[] args) {
        byte[] intToByte = intToByte(8143);
        System.out.println(Arrays.toString(intToByte));
        System.out.println(byteToInt(intToByte));
    }

    public static byte[] intToByte(int i) {
        byte[] arr = new byte[4];
		/*
		arr[0] = (byte)((int)((i >> 0 * 8) & 0xff));
		arr[1] = (byte)((int)((i >> 1 * 8) & 0xff));
		arr[2] = (byte)((int)((i >> 2 * 8) & 0xff));
		arr[3] = (byte)((int)((i >> 3 * 8) & 0xff));
		*/
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (byte) ((int) ((i >> j * 8) & 0xff));
        }
        return arr;
    }

    public static int byteToInt(byte[] arr) {
		/*
		int r0 = (int)((arr[0]& 0xff) << 0 * 8);
		int r1 = (int)((arr[1]& 0xff) << 1 * 8);
		int r2 = (int)((arr[2]& 0xff) << 2 * 8);
		int r3 = (int)((arr[3]& 0xff) << 3 * 8);
		*/
        int result = 0;
        for (int j = 0; j < arr.length; j++) {
            result += (int) ((arr[j] & 0xff) << j * 8);
        }
        return result;
    }
}