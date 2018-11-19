package com.blue.fish.se.io.file;

import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

class BigMappedByteBufferReader {
    private MappedByteBuffer[] mappedByteBuffers;
    private FileInputStream inputStream;
    private FileChannel fileChannel;

    private int bufferCountIndex = 0;
    private int bufferCount;

    private int byteBufferSize;
    private byte[] byteBuffer;

    public BigMappedByteBufferReader(String fileName, int byteBufferSize) throws Exception {
        this.inputStream = new FileInputStream(fileName);
        this.fileChannel = inputStream.getChannel();
        long fileSize = fileChannel.size();
        this.bufferCount = (int) Math.ceil((double) fileSize / (double) Integer.MAX_VALUE);
        this.mappedByteBuffers = new MappedByteBuffer[bufferCount];
        this.byteBufferSize = byteBufferSize;

        long preLength = 0;
        long regionSize = Integer.MAX_VALUE;
        for (int i = 0; i < bufferCount; i++) {
            if (fileSize - preLength < Integer.MAX_VALUE) {
                regionSize = fileSize - preLength;
            }
            mappedByteBuffers[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY, preLength, regionSize);
            preLength += regionSize;
        }
    }

    public synchronized int read() {
        if (bufferCountIndex >= bufferCount) {
            return -1;
        }

        int limit = mappedByteBuffers[bufferCountIndex].limit();
        int position = mappedByteBuffers[bufferCountIndex].position();

        int realSize = byteBufferSize;
        if (limit - position < byteBufferSize) {
            realSize = limit - position;
        }
        byteBuffer = new byte[realSize];
        mappedByteBuffers[bufferCountIndex].get(byteBuffer);

        //current fragment is end, goto next fragment start.
        if (realSize < byteBufferSize && bufferCountIndex < bufferCount) {
            bufferCountIndex++;
        }
        return realSize;
    }

    public void close() throws Exception {
        fileChannel.close();
        inputStream.close();
        for (MappedByteBuffer byteBuffer: mappedByteBuffers) {
            byteBuffer.clear();
        }
        byteBuffer = null;
    }

    public synchronized byte[] getCurrentBytes() {
        return byteBuffer;
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        BigMappedByteBufferReader reader = new BigMappedByteBufferReader("superbig.txt", 1024);
        while (reader.read() != -1) {
            byte[] bytes = reader.getCurrentBytes();
            //超大文件搞事情
            System.out.println(new String(bytes));
        }
        reader.close();
    }
}