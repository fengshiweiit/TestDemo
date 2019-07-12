package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) throws IOException {
        //服务端监听8080端口
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(reader.readLine());

        inputStream.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
