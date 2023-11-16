package fi.utu.tech.assignment2;
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

                InputStream input = s.getInputStream();
                OutputStream output = s.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println(message);

                serverSocket.close();
                input.close();
                output.close();

            }
        } catch (Exception e){

        }
    }
}

