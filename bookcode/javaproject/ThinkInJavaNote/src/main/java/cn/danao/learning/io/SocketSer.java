package cn.danao.learning.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * date 2020/4/22 11:42 <br/>
 * descriptionclass <br/>
 * socket编程测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class SocketSer {

    public static void main(String[] args) {
        int port = 8888;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("启动socket服务,端口是 " + port);
            while (true) {
                System.out.println("socket服务");
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    System.out.println("监听服务。处理socket");
                    InputStream is = null;
                    try {
                        is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        //获得输出流
                        OutputStream os = socket.getOutputStream();
                        PrintWriter pw = new PrintWriter(os);
                        //4.读取用户输入信息
                        String info = null;
                        while (!((info = br.readLine()) == null)) {
                            System.out.println("我是服务器，用户信息为：" + info);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
