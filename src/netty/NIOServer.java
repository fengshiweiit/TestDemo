package netty;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;


public class NIOServer {

    public static void main(String[] args) throws Exception {
        //创建一个Channel 用于监听客户端的连接
        //他是所有客户端连接的父管道（父管道！！！）
        ServerSocketChannel channel = ServerSocketChannel.open();

        ServerSocket socket = channel.socket();
        //绑定ip端口
        socket.bind(new InetSocketAddress(8080));
        //设置为非阻塞
        channel.configureBlocking(false);

        //开启一个多路复用器Selector
        Selector selector = Selector.open();
        //将channel注册到selector上
        channel.register(selector, SelectionKey.OP_ACCEPT);

        new Thread(new ReactorTask(selector)).start();
        System.out.println("nio server started");
    }
}
