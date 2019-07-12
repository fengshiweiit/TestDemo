package socketTest;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("Hello World");
        printWriter.close();
        outputStream.close();
        socket.close();
    }
}
