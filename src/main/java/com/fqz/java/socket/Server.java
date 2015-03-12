package com.fqz.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/12
 * Time: 17:07
 *
 * 测试socket连接时，需要首先启动server，再启动client
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1.创建服务端Socket，指定端口号，并监听
            ServerSocket serverSocket=new ServerSocket(8888);//端口号为0~65535，其中0~1023已经分配
            //2.调用accept()方法，来监听端口号，会阻塞自己直到有客户端请求8888端口
            System.out.println("服务器即将启动，等待客户端的连接*****");
            Socket socket = serverSocket.accept();
            //3.获取输入流（输入、输出中的入和出相对于程序），并读取客户端信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while((info = br.readLine()) != null){
                System.out.println("我是服务器，客户端说："+info);

            }

            //4.关闭资源
            socket.shutdownInput();//关闭输入流
            br.close();
            isr.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
