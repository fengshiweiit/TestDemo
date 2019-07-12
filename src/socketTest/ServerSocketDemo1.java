package socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo1 {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            //阻塞过程，直到有客户端连接
            Socket socket = server.accept();
            System.out.println("accept from client");

            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter os = new PrintWriter(socket.getOutputStream());

            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            //拿到客户端的信息
            //ps: readline方法是会阻塞的
            System.out.println("Client:" + is.readLine());

            String line = sin.readLine();
            System.out.println("test block");
            while (!line.equals("bye")) {
                //输出数据
                os.println(line);
                os.flush();
                System.out.println("Server:" + line);
                System.out.println("Client:" + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
