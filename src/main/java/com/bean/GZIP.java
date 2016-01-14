package com.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIP {

    /**
     * string compress
     *
     * @param str to be compress
     * @return compressed
     * @throws IOException
     */
    public static String compress(String str) throws IOException {
        if (null == str || str.length() <= 0) {
            return str;
        }
        // create an outputstream to store bytes data
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // gzip outputstream for write byte data
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        // write byte data to gzip output string
        gzip.write(str.getBytes()); //use default byte date "utf-8" to encode string data
        gzip.close();
        // decode byte data to string results
        return out.toString("ISO-8859-1");
    }

    /**
     * uncompress data
     *
     * @param str to be uncompress
     * @return after uncompressed
     * @throws IOException
     */
    public static String unCompress(String str) throws IOException {
        if (null == str || str.length() <= 0) {
            return str;
        }
        // create an outputstream to restore byte data
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // create an inputstream to restore byte data
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        // create an gzip inputstream to read zip data
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;

        // write byte data to outputstream
        while ((n = gzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        //return uncompressed string
        return out.toString("utf-8");
    }
}
