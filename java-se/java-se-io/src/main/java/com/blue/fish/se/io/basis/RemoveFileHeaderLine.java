package com.blue.fish.se.io.basis;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Java 中不创建临时文件的情况下如何删除文件前面指定行内容<br/>
 * 想往一个文件记录一些信息，当文件大小大于指定阈值时就让文件缩小一半（即丢弃前面的记录，保留最近追加的）
 */
public class RemoveFileHeaderLine {


    public static void main(String[] args) throws Exception {
        File file = new File("temp/remove.txt");
        removeFileHeaderLines(file, 5);
    }

    private static boolean removeFileHeaderLines(File file, int clearHeaderLines) throws Exception {
        RandomAccessFile accessFile = null;
        try{
            accessFile = new RandomAccessFile(file, "rw");
            long writePosition = accessFile.getFilePointer();
            for (int i = 0 ; i < clearHeaderLines; i++){
                String line = accessFile.readLine();
                if(line == null){
                    break;
                }
            }

            long readPosition = accessFile.getFilePointer();

            byte[] buffer = new byte[1024];
            int num;
            while (-1 != (num = accessFile.read(buffer))) {
                accessFile.seek(writePosition);
                accessFile.write(buffer, 0, num);
                readPosition += num;
                writePosition += num;
                accessFile.seek(readPosition);
            }
            accessFile.setLength(writePosition);
            return true;
        } catch(Throwable e){
            return false;
        } finally{
            IOUtils.closeQuietly(accessFile);
        }
    }
}
