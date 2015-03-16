package com.fqz.java.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/12
 * Time: 17:15
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.客户端创建Socket，即Socket，指定服务端地址和端口
            Socket socket = new Socket("localhost",8888);//服务器在本地，可以使用127.0.0.1或者localhost
            //2.获取输出流，用来向服务器端发送信息
            OutputStream os = socket.getOutputStream();//获取字节输出流
            PrintWriter pw = new PrintWriter(os);//将字节输出流包装成字符打印流
            pw.write("用户名：admin");
            pw.flush();//刷新缓存来发送信息
            //3.关闭资源
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
