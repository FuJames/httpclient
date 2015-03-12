package com.fqz.java.socket;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/12
 * Time: 16:27
 * 根据InetAddress入口只能找到大商场，
 * URL是商场的资源地址。
 */
public class URLUtil {
    public static void url(){
        try {
            URL datayes = new URL("http://www.datayes.com");
            URL url = new URL(datayes,"/cloud?username=tom#test");//根据父亲url，创建子url，#后面表示锚点
            System.out.println(url.getProtocol());//需要指定协议，否则会抛出异常
            System.out.println(url.getHost());
            System.out.println(url.getPort());//
            System.out.println(url.getPath());//资源的相对路径

            //读取网页内容
            //程序中的输入输出都是以流的形式保存的，流中保存的实际上全都是字节文件。
            //获取字节输入流
            InputStream inputStream = url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader isr = new InputStreamReader(inputStream,"utf8");
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while(data != null){//循环读取字符
                System.out.println(data);
                data = br.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
