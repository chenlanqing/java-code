package com.blue.fish.se.io.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 重用FileInputStream
 *
 * @author bluefish 2019-07-19
 * @version 1.0.0
 */
public class ReuseFileInputStream {
    public static void main(String[] args) throws Exception {
        try (InputStream is = new FileInputStream("temp/test.txt");
             OutputStream os1 = new FileOutputStream("temp/test1.txt");
             OutputStream os2 = new FileOutputStream("temp/test2.txt")) {

            if (!is.markSupported()) {
                System.out.println("不支持Mark");
            }

            int len;
            while ((len = is.read()) > 0) {
                os1.write(len);
                if (((char)len) == 'W') {
                    is.mark(len);
                }
            }

            is.reset();
            while ((len = is.read()) > 0) {
                os2.write(len);
            }
        }
    }
}
