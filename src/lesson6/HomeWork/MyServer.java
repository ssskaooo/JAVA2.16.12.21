package lesson6.HomeWork;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

    private static final int DEFAULT_PORT = 8189;

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if(args.length != 0){
            port = Integer.parseInt(args[0]);
        }
        new MyServer().start(port);
    }

    public void start(int port) throws IOException {
        ServerSocket socket = null;
        Socket clientSocket = null;
        Thread inputThread = null;

        try {
            socket = new ServerSocket(port);
            System.out.println("Server started.");
            clientSocket = socket.accept();
            System.out.println("Client connection");
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            inputThread = runInutThread(inputStream);
            runOutputLoop(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (clientSocket != null) clientSocket.close();
            if (socket != null) socket.close();
        }

    }

    private void runOutputLoop(DataOutputStream outputStream) throws IOException{
        Scanner scanner = new Scanner(System.in);
        while (true){
            String msg = scanner.next();
            outputStream.writeUTF(msg);
            if(msg.equals("/end")){
                break;
            }
        }
    }

    private Thread runInutThread(DataInputStream inputStream){
        Thread thread = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()){
                try {
                    String msg = inputStream.readUTF();
                    System.out.println("From client: " + msg);
                    if(msg.equals("/end")){
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Connection was closed");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }
}
