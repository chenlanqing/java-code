package com.blue.fish.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author bluefish 2019-06-16
 * @version 1.0.0
 */
public class ExceptionByteCode {

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
