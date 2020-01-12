package com.blue.fish.se.io.io;

import com.google.common.io.CharStreams;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author bluefish 2020-01-01
 * @version 1.0.0
 */
public class InputStreamToStringWay {

    public static void main(String[] args) {

    }

    private static String bufferedString(InputStream in) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder sb = new StringBuilder();
        Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        int charRead;

        while ( (charRead = reader.read(buffer, 0, buffer.length)) > 0) {
            sb.append(buffer, 0 , charRead);
        }
        return sb.toString();
    }

    private static String streamsApi(InputStream in) {
        return new BufferedReader(new InputStreamReader(in)).lines().parallel().collect(Collectors.joining("\n"));
    }

    private static String scannner(InputStream in) {
        Scanner scanner = new Scanner(in).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    private static String guava(InputStream in, String encoding) throws IOException {
        return CharStreams.toString(new InputStreamReader(in, encoding));
    }

    private static String apacheIoWriter(InputStream in, String encoding) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(in, writer, encoding);
        return writer.toString();
    }

    private static String apacheIo(InputStream in, String encoding) throws IOException {
        return IOUtils.toString(in, encoding);
    }
}
