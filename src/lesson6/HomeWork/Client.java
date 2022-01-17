package lesson6.HomeWork;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        new Client().start("localhost", 8189); // подключаемся клиентом к хосту лок и порту
    }

    public void start(String host, int port) throws IOException { // подключение к серверу
        Socket socket = null;
        Thread inputThread = null;
        try {
            socket = new Socket(host, port);
            System.out.println("Client started");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            inputThread = runInputThread(inputStream);
            runOutputLoop(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt(); // вызываем метод чтобы заврешить поток
            if (socket != null) socket.close(); // вызываем мтеод чтобы закрыть сокет
        }
    }

    private void runOutputLoop(DataOutputStream outputStream) throws IOException { // бесконечно принимает
        Scanner scanner = new Scanner(System.in);  // сообщения от пользователя
        while (true) {
            String msg = scanner.next();
            outputStream.writeUTF(msg);
            if (msg.equals("/end")) {
                break;
            }
        }
    }

    private Thread runInputThread(DataInputStream inputStream) { // бесконечный поток с чтением сообщения
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String msg = inputStream.readUTF();
                    System.out.println("From server: " + msg);
                    if (msg.equals("/end")) {
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
