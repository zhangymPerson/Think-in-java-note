package cn.danao.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * date 2020/12/4 17:07 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class NIOServer {
    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            try {
                selector.select();
                //SelectionKey，表示 Selector 和网络通道的注册关系, 共四种:
                // int OP_ACCEPT：有新的网络连接可以 accept，值为 16
                // int OP_CONNECT：代表连接已经建立，值为 8
                // int OP_READ：代表读操作，值为 1
                // int OP_WRITE：代表写操作，值为 4
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {
                    final SocketChannel client;
                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                            client = serverSocketChannel1.accept();
                            //配置为非阻塞。否则报错
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);

                            String key = "[" + UUID.randomUUID().toString() + "]";
                            clientMap.put(key, client);

                        } else if (selectionKey.isReadable()) {
                            client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);

                            if (count > 0) {
                                readBuffer.flip();
                                Charset charset = Charset.forName("utf-8");
                                String reciveString = String.valueOf(charset.decode(readBuffer).array());
                                System.out.println(client + ":" + reciveString);

                                String senderKey = null;
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (client == entry.getValue()) {
                                        senderKey = entry.getKey();
                                        break;
                                    }
                                }
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel socketChannel = entry.getValue();
                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put((senderKey + ":" + reciveString).getBytes());

                                    writeBuffer.flip();
                                    socketChannel.write(writeBuffer);
                                }
                            }
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
                //将key清空，相当于Itetor一次性remove
                selectionKeys.clear();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
