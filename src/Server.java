import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(48648);
        int clientCount = 0;
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + "№ " + ++clientCount);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = "Client № " + clientCount + " " + "your message length is " + request.length() + "\n";
            writer.write(response);
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
//            serverSocket.close();
    }
}
