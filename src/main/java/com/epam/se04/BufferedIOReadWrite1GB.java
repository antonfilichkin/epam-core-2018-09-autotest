package com.epam.se04;

import java.io.*;
import java.util.*;

public class BufferedIOReadWrite1GB {

    public static void main(String[] args) throws IOException {

        //Testing speeds of File Writing 50Mb
        final int BYTE_ARRAY_SIZE = 5_242_880;
        final byte[] byteArray = createRandomByteArray(BYTE_ARRAY_SIZE);

        byte[] in;

        final String PATH_TO_FILE = "..\\out.txt";

        long startTime;
        long stopTime;

        //Buffered
        System.out.println("BufferedOutputStream");
        startTime = System.nanoTime();
        writeToBufferedFileOutputStream(byteArray,PATH_TO_FILE);
        stopTime = System.nanoTime();
        printTimeToRun("Writing to array of: ", BYTE_ARRAY_SIZE, startTime, stopTime);

        System.out.println();

        System.out.println("BufferedInputStream");
        startTime = System.nanoTime();
        in = readFromBufferedFileInputStream(PATH_TO_FILE);
        stopTime = System.nanoTime();
        printTimeToRun("Reading array of: ", BYTE_ARRAY_SIZE, startTime, stopTime);
        System.out.println("Read the same array - ? " + Arrays.equals(byteArray, in));

        System.out.println();

        //Unbuffered
        System.out.println("FileOutputStream");
        startTime = System.nanoTime();
        writeToFileOutputStream(byteArray,PATH_TO_FILE);
        stopTime = System.nanoTime();
        printTimeToRun("Writing to array of: ", BYTE_ARRAY_SIZE, startTime, stopTime);

        System.out.println();

        System.out.println("FileInputStream");
        startTime = System.nanoTime();
        in = readFromFileInputStream(PATH_TO_FILE);
        stopTime = System.nanoTime();
        printTimeToRun("Reading to array of: ", BYTE_ARRAY_SIZE, startTime, stopTime);
        System.out.println("Read the same array - ? " + Arrays.equals(byteArray, in));
    }

    private static void writeToBufferedFileOutputStream(byte[] byteArray, String pathToFile) throws IOException {
        OutputStream os = new FileOutputStream(pathToFile);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        for (byte element : byteArray) {
            bos.write(element);
        }
        bos.close();
    }

    private static void writeToFileOutputStream(byte[] byteArray, String pathToFile) throws IOException {
        OutputStream os = new FileOutputStream(pathToFile);
        for (byte element : byteArray) {
            os.write(element);
        }
        os.close();
    }

    private static byte[] readFromBufferedFileInputStream(String pathToFile) throws IOException {
        InputStream is = new FileInputStream(pathToFile);
        BufferedInputStream bis = new BufferedInputStream(is);
        List<Byte> bytes = new ArrayList<>();
        int currentByte;
        while((currentByte = bis.read()) >= 0){
            bytes.add((byte) currentByte);
        }
        is.close();

        byte[] output = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); ++i) {
            output[i] = bytes.get(i);
        }

        return output;
    }

    private static byte[] readFromFileInputStream(String pathToFile) throws IOException {
        InputStream is = new FileInputStream(pathToFile);
        List<Byte> bytes = new ArrayList<>();
        int currentByte;
        while((currentByte = is.read()) >= 0){
            bytes.add((byte) currentByte);
        }
        is.close();

        byte[] output = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); ++i) {
            output[i] = bytes.get(i);
        }

        return output;
    }

    private static void printTimeToRun(String message, int byteArraySize, long startTime, long stopTime) {
        System.out.println(message + byteArraySize / 1_048_576 + "MB in " + (stopTime - startTime) / 1_000_000_000 + "s");
    }

    private static byte[] createRandomByteArray(int size) {
        byte[] randomBytes = new byte[size];
        new Random().nextBytes(randomBytes);
        return randomBytes;
    }
}
