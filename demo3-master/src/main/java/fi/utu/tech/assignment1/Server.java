package fi.utu.tech.assignment1;
import java.net.*;

import java.io.*;


public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Aloitetaan");

            while (true) {
                Socket s = serverSocket.accept();
                
                System.out.println("Yhdistetty");
                serverSocket.close();

            }
        } catch (Exception e){

        }
    }
}
