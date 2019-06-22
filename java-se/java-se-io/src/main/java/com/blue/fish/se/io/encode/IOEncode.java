package com.blue.fish.se.io.encode;

import java.io.*;

/**
 * @author bluefish 2019-06-21
 * @version 1.0.0
 */
public class IOEncode {

    public static void main(String[] args) throws IOException {
        String file = "c:/stream.txt";
        String charset = "UTF-8";
        // 写字符换转成字节流
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(
                outputStream, charset);
        try {
            writer.write("这是要保存的中文字符");
        } finally {
            writer.close();
        }
        // 读取字节转换成字符
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(
                inputStream, charset);
        StringBuffer buffer = new StringBuffer();
        char[] buf = new char[64];
        int count = 0;
        try {
            while ((count = reader.read(buf)) != -1) {
                buffer.append(buffer, 0, count);
            }
        } finally {
            reader.close();
        }
    }
}
