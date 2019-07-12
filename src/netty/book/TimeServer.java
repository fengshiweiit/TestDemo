package netty.book;

/**
 * @Description
 * @Date 2019/6/24 20:29
 * @Created by Feng Shiwei
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
