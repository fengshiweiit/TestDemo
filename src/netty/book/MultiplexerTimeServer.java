package netty.book;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description
 * @Date 2019/6/11 21:18
 * @Created by Feng Shiwei
 */

public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel servChannel;

    private volatile boolean stop;

    /**
     * 初始化多路复用器
     * 绑定端口
     */
    public MultiplexerTimeServer(int port) {
        try {
            //开启一个多路复用器Selector
            selector = Selector.open();
            //开启一个channel，设置为非阻塞
            servChannel = ServerSocketChannel.open();
            servChannel.configureBlocking(false);
            //绑定ip和端口号
            servChannel.socket().bind(new InetSocketAddress(port));
            //将channel注册到selector上,监听Accept事件
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server start in port :" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        this.stop = true;
    }


    @Override
    public void run() {
        while (!stop) {
            try {
                //无论是否有读写等事件发生 selector每隔1s都被唤醒一次
                selector.select();
                //得到所有注册到selector上的channel的selectKey
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                //轮询selectKey
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    handleInput(key);
                    if (key != null) {
                        key.cancel();
                        if (key.channel() != null) {
                            key.channel().close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (selector != null) {
                try {
                    //当多路复用器关闭后 所有注册在上面的channel和pipe都会被自动关闭
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            //处理新接入的请求消息
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                //通过ServerSocketChannel的accept接收客户端的连接请求并创建SocketChannel实例
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("thr server receive body : " + body);
                    String currentTime = new Date(System.currentTimeMillis()).toString();
                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doWrite(SocketChannel sc, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            sc.write(writeBuffer);
        }
    }
}
