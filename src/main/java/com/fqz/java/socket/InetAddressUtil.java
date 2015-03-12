package com.fqz.java.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/12
 * Time: 16:22
 */
public class InetAddressUtil {
    public static void getAddress() throws UnknownHostException {
        //查看默认编码方式
        String defaultCharsetName= Charset.defaultCharset().displayName();
        System.out.println("defaultCharsetName:"+defaultCharsetName);

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("主机名："+address.getHostName());
        System.out.println("IP地址："+address.getHostAddress());
        byte[] bytes = address.getAddress();//byte占有8个bit
        System.out.println(Arrays.toString(bytes));

    }
}
