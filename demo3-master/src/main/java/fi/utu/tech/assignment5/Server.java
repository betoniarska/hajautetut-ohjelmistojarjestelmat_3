package fi.utu.tech.assignment5;

import fi.utu.tech.assignment3.ClientHandler;

import java.net.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class Server {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int i = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Aloitetaan");

            while (true) {
                Socket s = serverSocket.accept();
                i++;

                System.out.println("Yhdistetty");
                System.out.println(i + ". Yhteys");

                fi.utu.tech.assignment5.ClientHandler handler = new fi.utu.tech.assignment5.ClientHandler(s);

                executorService.execute(handler);

            }
        } catch (Exception e){

        } finally {
            executorService.shutdown();
        }
    }
}


