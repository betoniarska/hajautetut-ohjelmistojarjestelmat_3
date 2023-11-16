package fi.utu.tech.assignment6;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        Hub h = new Hub();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int i = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(12345);

            while (true) {

                Socket s = serverSocket.accept();

                fi.utu.tech.assignment6.ClientHandler handler = new fi.utu.tech.assignment6.ClientHandler(s, h);
                executorService.execute(handler);
            }
        } catch (Exception e){

        } finally {
            executorService.shutdown();
        }
    }
}