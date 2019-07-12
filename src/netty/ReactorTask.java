package netty;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

public class ReactorTask implements Runnable {

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private Selector selector;

    public ReactorTask(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //开始轮询准备就绪的key
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();
                    if (key.isValid()) {
                        try {
                            if (key.isReadable()) {
                                System.out.println("read");
                                read(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }
                        try {
                            if (key.isAcceptable()) {
//                                System.out.println("accept");
                                accept(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }

//                        try {
//                            if (key.isWritable()) {
//                                write(key);
//                            }
//                        } catch (CancelledKeyException cke) {
//                            key.cancel();
//                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) {

        try {
            ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
            SocketChannel channel = serverChannel.accept();
            channel.configureBlocking(false);
            channel.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            this.readBuffer.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            int readLength = channel.read(readBuffer);
            if (readLength == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            this.readBuffer.flip();
            byte[] datas = new byte[readBuffer.remaining()];
            readBuffer.get(datas);
            System.out.println("From " + channel.getRemoteAddress() + "Client: " + new String(datas, "UTF-8"));
            channel.register(this.selector, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void write(SelectionKey key) {
        this.writeBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        Scanner reader = new Scanner(System.in);
        try {
            String line = reader.nextLine();
            writeBuffer.put(line.getBytes("UTF-8"));
            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
