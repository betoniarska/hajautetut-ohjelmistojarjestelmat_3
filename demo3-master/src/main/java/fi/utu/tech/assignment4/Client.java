package fi.utu.tech.assignment4;


import javax.sql.rowset.serial.SQLInputImpl;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {


        String address = "localhost";


        try {
            Socket s = new Socket(address, 12345);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream(), true);

            String message = "Hello";
            writer.println(message); // println on hyvä koska automaattisesti erottelee rivinvaihdoilla
            writer.flush();


            String reply = "";

            while ((reply = reader.readLine()) != null) {
                System.out.println("Varmistus saaatu");
                writer.println("quit");
                writer.flush();
            }
            //output.write(message.getBytes());

            s.close();

        } catch (Exception e) {

        }
    }
}