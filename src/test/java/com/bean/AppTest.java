package com.bean;

import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple GZIP.
 */
public class AppTest {
    private static String data = "{\"hotel\":{\"items\":[{\"cpId\":\"1451852\",\"cpSource\":\"ctrip\",\"id\":\"60261\"},{\"cpId\":\"2000849\",\"cpSource\":\"ctrip\",\"id\":\"59236\"},{\"cpId\":\"798681\",\"cpSource\":\"ctrip\",\"id\":\"61045\"},{\"cpId\":\"3327287\",\"cpSource\":\"ctrip\",\"id\":\"60712\"},{\"cpId\":\"1685114\",\"cpSource\":\"ctrip\",\"id\":\"59844\"},{\"cpId\":\"441546\",\"cpSource\":\"ctrip\",\"id\":\"61510\"},{\"cpId\":\"738301\",\"cpSource\":\"ctrip\",\"id\":\"61096\"},{\"cpId\":\"2299749\",\"cpSource\":\"ctrip\",\"id\":\"61691\"},{\"cpId\":\"1185139\",\"cpSource\":\"ctrip\",\"id\":\"60736\"},{\"cpId\":\"919838\",\"cpSource\":\"ctrip\",\"id\":\"60923\"}],\"totalCount\":10,\"type\":\"hotel\"},\"movie\":{\"items\":[],\"totalCount\":0,\"type\":\"movie\"}}";

    /**
     * test compress and uncompress
     */
    @Test
    public void GZipCompressTest() {
        try {
            /*compress*/
            String compressData = GZIP.compress(data);
            System.out.println("compress results=[" + compressData + "]");
            System.out.println("before compress size=[" + data.getBytes().length + "]");
            System.out.println("after compress size=[" + compressData.getBytes().length + "]");

            /*uncompress*/
            String uncompressData = GZIP.unCompress(compressData);
            System.out.println("uncompress results=[" + uncompressData + "]");
            System.out.println("after uncompress size=[" + uncompressData.getBytes().length + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
