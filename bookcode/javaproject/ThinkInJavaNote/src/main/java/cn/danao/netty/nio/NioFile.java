package cn.danao.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * date 2020/12/6 10:32 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class NioFile {
    /**
     * 完成文件的复制（读取和写入）
     * 步骤1.获取输入输出管道
     * 2.创建buffer
     * 3.写入buffer
     * 4.读出buffer
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("1.txt");
        FileOutputStream out = new FileOutputStream("2.txt");
        // 通道 转换 成通道
        FileChannel fileInChannel = in.getChannel();
        FileChannel fileOutChannel = out.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            /*这里必须使用clear（）复原，如果不复原，positon和limit位置相同
            此时不会读取数据，因为可以认为buffer没有空间了，所以read=0,
            read都没有等于-1的机会，等于-1是因为输入流那边文件到头了返回-1,
            这种情况根本没有回去读，所以为0，然后之后flip把postition刷新回了0位置
            开始循环读出数据。*/
            byteBuffer.clear();
            //通过通道读取数据
            int read = fileInChannel.read(byteBuffer);
            System.out.println("read:" + read);
            if (-1 == read) {
                break;
            }
            byteBuffer.flip();
            //写数据
            fileOutChannel.write(byteBuffer);

        }
        fileInChannel.close();
        fileOutChannel.close();
    }

}
