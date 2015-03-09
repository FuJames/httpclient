package com.fqz.java;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/9
 * Time: 13:35
 */
public class HttpUtilTest extends TestCase {
    public void testGet() throws IOException {
        String url = "http://dataapi01.cloud-data.datayes.com/market/getTickRTSnapshot.json?field=&securityID=000001.XSHG&callback=";
        String body = HttpUtil.getResource(url);
        System.out.println(body);
    }
}
